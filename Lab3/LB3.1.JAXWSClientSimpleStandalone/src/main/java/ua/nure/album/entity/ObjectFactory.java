
package ua.nure.album.entity;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.album.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Album_QNAME = new QName("http://album.nure.ua/entity", "Album");
    private final static QName _Image_QNAME = new QName("http://album.nure.ua/entity", "Image");
    private final static QName _ListAlbums_QNAME = new QName("http://album.nure.ua/entity", "listAlbums");
    private final static QName _Return_QNAME = new QName("http://album.nure.ua/entity", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.album.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Album }
     * 
     */
    public Album createAlbum() {
        return new Album();
    }

    /**
     * Create an instance of {@link Image }
     * 
     */
    public Image createImage() {
        return new Image();
    }

    /**
     * Create an instance of {@link Entity }
     * 
     */
    public Entity createEntity() {
        return new Entity();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Album }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Album }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/entity", name = "Album")
    public JAXBElement<Album> createAlbum(Album value) {
        return new JAXBElement<Album>(_Album_QNAME, Album.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Image }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Image }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/entity", name = "Image")
    public JAXBElement<Image> createImage(Image value) {
        return new JAXBElement<Image>(_Image_QNAME, Image.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Album }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Album }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/entity", name = "listAlbums")
    public JAXBElement<Album> createListAlbums(Album value) {
        return new JAXBElement<Album>(_ListAlbums_QNAME, Album.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/entity", name = "return")
    public JAXBElement<Integer> createReturn(Integer value) {
        return new JAXBElement<Integer>(_Return_QNAME, Integer.class, null, value);
    }

}
