package ua.nure.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.album.entity.AccessLevel;
import ua.nure.album.entity.Album;
import ua.nure.album.entity.Author;
import ua.nure.album.entity.Image;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SAXParser extends DefaultHandler {
    private static final boolean LOG_ENABLED = true;

    public static void log(Object o) {
        if (LOG_ENABLED) {
            System.out.println(o);
        }
    }

    private String current;
    private List<Album> albums;
    private Author author;
    private Album album;
    private Image image;

    public List<Album> getAlbums() {
        return albums;
    }

    @Override
    public void error(org.xml.sax.SAXParseException e) throws SAXException {
        System.err.println(e.getMessage());
    }

    public List<Album> parse(InputStream in, Schema schema) throws ParserConfigurationException, SAXException, IOException {

        /**
         * SAXParserFactory factory = SAXParserFactory.newInstance();
         *
         * // to be compliant, completely disable DOCTYPE declaration:
         * factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
         *
         * // or completely disable external entities declarations:
         * factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
         * factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
         *
         * // or prohibit the use of all protocols by external entities:
         * SAXParser parser = factory.newSAXParser(); // Noncompliant
         * parser.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
         * parser.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
         *
         */

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);

        factory.setSchema(schema);
        javax.xml.parsers.SAXParser parser = factory.newSAXParser();
        parser.parse(in, this);

        return this.albums;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        this.current = localName;

        if (Const.TAG_ALBUMS.equals(this.current)) {
            this.albums = new ArrayList<>();
        } else if (Const.TAG_album.equals(this.current)) {
            this.album = new Album();
            if (attributes.getLength() > 0) {
                this.album.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        } else if (Const.TAG_IMAGE.equals(this.current)) {
            this.image = new Image();
            if (attributes.getLength() > 0) {
                this.image.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        } else if (Const.TAG_CREATED_BY.equals(this.current)) {
            this.author = new Author();
            if (attributes.getLength() > 0) {
                this.author.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        if (value.isBlank()) {
            return;
        }
        if (Const.TAG_HEADER.equals(this.current)) {
            this.album.setHeader(value);
        } else if (Const.TAG_TEXT.equals(this.current)) {
            this.album.setText(value);
        } else if (Const.TAG_DATE.equals(this.current)) {
            this.album.setDate(value);
        } else if (Const.TAG_ACCESS_LEVEL.equals(this.current)) {
            this.album.setAccessLevel(AccessLevel.fromValue(value));
        } else if (Const.TAG_IMAGE_URL.equals(this.current)) {
            this.image.setImageUrl(value);
        } else if (Const.TAG_USERNAME.equals(this.current)) {
            this.author.setUsername(value);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (Const.TAG_IMAGE.equals(localName)) {
            this.album.getImage().add(this.image);
            log(this.current + " " + this.image);
        } else if (Const.TAG_CREATED_BY.equals(localName)) {
            this.album.setCreatedBy(this.author);
            log(this.current + " " + this.author);
        } else if (Const.TAG_album.equals(localName)) {
            this.albums.add(this.album);
            log(this.current + " " + this.album);
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Create against validation schema
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(Const.XSD_FILE));

        System.out.println("--== SAX Parser ==--");
        SAXParser parser = new SAXParser();
        parser.parse(new FileInputStream("xml/Albums.xml"), schema);
        List<Album> albums = parser.getAlbums();
        System.out.println("====================================");
        System.out.println("Here is the albums: \n" + albums);
        System.out.println("====================================");
        parser.parse(new FileInputStream(Const.INVALID_XML_FILE), schema);
        albums = parser.getAlbums();
        System.out.println("====================================");
        System.out.println("Here is the invalid albums: \n" + albums);
        System.out.println("====================================");
    }
}


