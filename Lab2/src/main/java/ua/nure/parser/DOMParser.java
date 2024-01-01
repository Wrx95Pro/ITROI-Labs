package ua.nure.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.album.entity.AccessLevel;
import ua.nure.album.entity.Album;
import ua.nure.album.entity.Author;
import ua.nure.album.entity.Image;

public class DOMParser {
    private static boolean logEnabled = true;

    private static void log(Object o) {
        if (logEnabled) {
            System.out.println(o);
        }
    }

    private Album parseAlbum(Node node) {
        Album album = new Album();
        NodeList nodes = node.getChildNodes();
        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            album.setId(attrId);
        }

        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);
            if (Const.TAG_TEXT.equals(localName)) {
                album.setText(textContent);
            } else if (Const.TAG_DATE.equals(localName)) {
                album.setDate(textContent);
            } else if (Const.TAG_HEADER.equals(localName)) {
                album.setHeader(textContent);
            }
            else if (Const.TAG_IMAGE.equals(localName)) {
                album.getImage().add(parseImage(item));
            } else if (Const.TAG_CREATED_BY.equals(localName)) {
                album.setCreatedBy(parseAuthor(item));
            }else if (Const.TAG_ACCESS_LEVEL.equals(localName)) {
                album.setAccessLevel(AccessLevel.fromValue(textContent));
                this.LogFieldAndValue(localName, textContent);
            }
        }

        return album;
    }

    private Image parseImage(Node node) {
        Image image = new Image();
        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            image.setId(attrId);
        }

        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);

            if (Const.TAG_IMAGE_URL.equals(localName)) {
                image.setImageUrl(textContent);
                this.LogFieldAndValue(localName, textContent);
            }
        }

        return image;
    }

    private Author parseAuthor(Node node) {
        Author author = new Author();

        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            author.setId(attrId);
        }

        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);

            if (Const.TAG_USERNAME.equals(localName)) {
                author.setUsername(textContent);
                this.LogFieldAndValue(localName, textContent);
            }
        }

        return author;
    }

    private void LogFieldAndValue(String fieldName, String fieldValue) {
        log(fieldName + "=" + fieldValue);
    }

    private Integer GetAttributeIdFromNode(Node node) {
        if (node.hasAttributes()) {
            NamedNodeMap attrs = node.getAttributes();
            Node item = attrs.getNamedItem(Const.ATTRIBUTE_ID);
            String textContent = item.getTextContent();
            log(item.getLocalName() + "=" + textContent);
            return Integer.parseInt(textContent);
        }

        return null;
    }

    public List<Album> parse(InputStream in, Schema schema)
            throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);

        // to be compliant, completely disable DOCTYPE declaration:
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        // or completely disable external entities declarations:
//		dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
//		dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

        // make parser validating against XSD, which internally referenced in XML doc
        // !!! OLD VULNERABLE FEATURE !!!
//		dbf.setFeature(Const.FEATURE__TURN_VALIDATION_ON, true);
//		dbf.setFeature(Const.FEATURE__TURN_SCHEMA_VALIDATION_ON, true);

        // set the validation against schema
        dbf.setSchema(schema);

        DocumentBuilder db = dbf.newDocumentBuilder();

        // setup validation error handler
        // the preferred way is the throwing an exception
        db.setErrorHandler(new DefaultHandler() {
            @Override
            public void error(SAXParseException e) throws SAXException {
                System.err.println(e.getMessage()); // log error
//				throw e;
            }
        });

        // get the top of the xml tree
        Document root = db.parse(in);

        List<Album> albums = new ArrayList<>();

        // get the root element of the xml document
        Element e = root.getDocumentElement();
        NodeList xmlAlbums = e.getElementsByTagNameNS(Const.ALBUMS_NAMESPACE_URI, Const.TAG_album);
        for (int i = 0; i < xmlAlbums.getLength(); i++) {
            albums.add(parseAlbum(xmlAlbums.item(i)));
        }

        return albums;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Create against validation schema
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("xml/Albums.xsd"));

        System.out.println("--== DOM Parser ==--");
        DOMParser domParser = new DOMParser();
        InputStream in = new FileInputStream("xml/Albums.xml");
        List<Album> albums = domParser.parse(in, schema);

        System.out.println("====================================");
        System.out.println("Here is the albums: \n" + albums);
        System.out.println("====================================");

        in = new FileInputStream("xml/invalid_albums.xml");
        albums = domParser.parse(in, schema);
        System.out.println("====================================");
        System.out.println("Here is the albums from invalid xml: \n" + albums);
        System.out.println("====================================");
    }
}
