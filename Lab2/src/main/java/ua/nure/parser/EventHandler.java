package ua.nure.parser;


import ua.nure.album.entity.AccessLevel;
import ua.nure.album.entity.Album;
import ua.nure.album.entity.Author;
import ua.nure.album.entity.Image;

import javax.xml.namespace.QName;
import javax.xml.stream.events.*;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    private static final boolean LOG_ENABLED = false;

    private String current;
    private Author author;
    private List<Album> albums;
    private Album album;
    private Image image;

    private static void log(Object o) {
        if (LOG_ENABLED) {
            System.out.println(o);
        }
    }

    public void endElement(XMLEvent event) {
        EndElement endElement = event.asEndElement();
        String localName = endElement.getName().getLocalPart();
        if (Const.TAG_IMAGE.equals(localName)) {
            this.album.getImage().add(this.image);
        } else if (Const.TAG_CREATED_BY.equals(localName)) {
            this.album.setCreatedBy(this.author);
        } else if (Const.TAG_album.equals(localName)) {
            this.albums.add(this.album);
        }
    }

    public void characters(XMLEvent event) {
        Characters characters = event.asCharacters();
        String value = characters.getData();
        log("Characters: " + this.current);
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

    public void startElement(XMLEvent event) {
        StartElement startElement = event.asStartElement();
        this.current = startElement.getName().getLocalPart();
        log("StartElement: " + startElement.getName());
        Attribute attr = startElement.getAttributeByName(new QName(Const.ATTRIBUTE_ID));

        if (Const.TAG_ALBUMS.equals(this.current)) {
            this.albums = new ArrayList<>();
        } else if (Const.TAG_album.equals(this.current)) {
            this.album = new Album();
            if (attr != null) {
                this.album.setId(Integer.parseInt(attr.getValue()));
            }
        } else if (Const.TAG_IMAGE.equals(this.current)) {
            this.image = new Image();
            if (attr != null) {
                this.album.setId(Integer.parseInt(attr.getValue()));
            }
        } else if (Const.TAG_CREATED_BY.equals(this.current)) {
            this.author = new Author();
            if (attr != null) {
                this.album.setId(Integer.parseInt(attr.getValue()));
            }
        }
    }

    public List<Album> getAlbums() {
        return albums;
    }
}
