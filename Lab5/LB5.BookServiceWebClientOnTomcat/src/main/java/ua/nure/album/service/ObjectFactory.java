
package ua.nure.album.service;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.album.service package.
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

    private final static QName _AddAlbum_QNAME = new QName("http://album.nure.ua/service", "addAlbum");
    private final static QName _AddAlbumResponse_QNAME = new QName("http://album.nure.ua/service", "addAlbumResponse");
    private final static QName _AddImage_QNAME = new QName("http://album.nure.ua/service", "addImage");
    private final static QName _AddImageResponse_QNAME = new QName("http://album.nure.ua/service", "addImageResponse");
    private final static QName _GetImageByUrl_QNAME = new QName("http://album.nure.ua/service", "getImageByUrl");
    private final static QName _GetImageByUrlResponse_QNAME = new QName("http://album.nure.ua/service", "getImageByUrlResponse");
    private final static QName _ListAlbums_QNAME = new QName("http://album.nure.ua/service", "listAlbums");
    private final static QName _ListAlbumsResponse_QNAME = new QName("http://album.nure.ua/service", "listAlbumsResponse");
    private final static QName _RemoveImage_QNAME = new QName("http://album.nure.ua/service", "removeImage");
    private final static QName _RemoveImageResponse_QNAME = new QName("http://album.nure.ua/service", "removeImageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.album.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddAlbum }
     * 
     */
    public AddAlbum createAddAlbum() {
        return new AddAlbum();
    }

    /**
     * Create an instance of {@link AddAlbumResponse }
     * 
     */
    public AddAlbumResponse createAddAlbumResponse() {
        return new AddAlbumResponse();
    }

    /**
     * Create an instance of {@link AddImage }
     * 
     */
    public AddImage createAddImage() {
        return new AddImage();
    }

    /**
     * Create an instance of {@link AddImageResponse }
     * 
     */
    public AddImageResponse createAddImageResponse() {
        return new AddImageResponse();
    }

    /**
     * Create an instance of {@link GetImageByUrl }
     * 
     */
    public GetImageByUrl createGetImageByUrl() {
        return new GetImageByUrl();
    }

    /**
     * Create an instance of {@link GetImageByUrlResponse }
     * 
     */
    public GetImageByUrlResponse createGetImageByUrlResponse() {
        return new GetImageByUrlResponse();
    }

    /**
     * Create an instance of {@link ListAlbums }
     * 
     */
    public ListAlbums createListAlbums() {
        return new ListAlbums();
    }

    /**
     * Create an instance of {@link ListAlbumsResponse }
     * 
     */
    public ListAlbumsResponse createListAlbumsResponse() {
        return new ListAlbumsResponse();
    }

    /**
     * Create an instance of {@link RemoveImage }
     * 
     */
    public RemoveImage createRemoveImage() {
        return new RemoveImage();
    }

    /**
     * Create an instance of {@link RemoveImageResponse }
     * 
     */
    public RemoveImageResponse createRemoveImageResponse() {
        return new RemoveImageResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAlbum }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddAlbum }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/service", name = "addAlbum")
    public JAXBElement<AddAlbum> createAddAlbum(AddAlbum value) {
        return new JAXBElement<AddAlbum>(_AddAlbum_QNAME, AddAlbum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAlbumResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddAlbumResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/service", name = "addAlbumResponse")
    public JAXBElement<AddAlbumResponse> createAddAlbumResponse(AddAlbumResponse value) {
        return new JAXBElement<AddAlbumResponse>(_AddAlbumResponse_QNAME, AddAlbumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddImage }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddImage }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/service", name = "addImage")
    public JAXBElement<AddImage> createAddImage(AddImage value) {
        return new JAXBElement<AddImage>(_AddImage_QNAME, AddImage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddImageResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddImageResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/service", name = "addImageResponse")
    public JAXBElement<AddImageResponse> createAddImageResponse(AddImageResponse value) {
        return new JAXBElement<AddImageResponse>(_AddImageResponse_QNAME, AddImageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetImageByUrl }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetImageByUrl }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/service", name = "getImageByUrl")
    public JAXBElement<GetImageByUrl> createGetImageByUrl(GetImageByUrl value) {
        return new JAXBElement<GetImageByUrl>(_GetImageByUrl_QNAME, GetImageByUrl.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetImageByUrlResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetImageByUrlResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/service", name = "getImageByUrlResponse")
    public JAXBElement<GetImageByUrlResponse> createGetImageByUrlResponse(GetImageByUrlResponse value) {
        return new JAXBElement<GetImageByUrlResponse>(_GetImageByUrlResponse_QNAME, GetImageByUrlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAlbums }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListAlbums }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/service", name = "listAlbums")
    public JAXBElement<ListAlbums> createListAlbums(ListAlbums value) {
        return new JAXBElement<ListAlbums>(_ListAlbums_QNAME, ListAlbums.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAlbumsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListAlbumsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/service", name = "listAlbumsResponse")
    public JAXBElement<ListAlbumsResponse> createListAlbumsResponse(ListAlbumsResponse value) {
        return new JAXBElement<ListAlbumsResponse>(_ListAlbumsResponse_QNAME, ListAlbumsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveImage }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveImage }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/service", name = "removeImage")
    public JAXBElement<RemoveImage> createRemoveImage(RemoveImage value) {
        return new JAXBElement<RemoveImage>(_RemoveImage_QNAME, RemoveImage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveImageResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveImageResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://album.nure.ua/service", name = "removeImageResponse")
    public JAXBElement<RemoveImageResponse> createRemoveImageResponse(RemoveImageResponse value) {
        return new JAXBElement<RemoveImageResponse>(_RemoveImageResponse_QNAME, RemoveImageResponse.class, null, value);
    }

}
