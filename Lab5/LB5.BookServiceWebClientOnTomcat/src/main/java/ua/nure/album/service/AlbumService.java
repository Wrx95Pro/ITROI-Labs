
package ua.nure.album.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;
import ua.nure.album.entity.Album;
import ua.nure.album.entity.Image;

import java.util.List;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "AlbumService", targetNamespace = "http://album.nure.ua/service")
@XmlSeeAlso({
    ua.nure.album.entity.ObjectFactory.class,
    ObjectFactory.class
})
public interface AlbumService {


    /**
     * 
     * @param imgUrl
     * @return
     *     returns ua.nure.album.entity.Image
     */
    @WebMethod
    @WebResult(name = "Image", targetNamespace = "http://album.nure.ua/entity")
    @RequestWrapper(localName = "getImageByUrl", targetNamespace = "http://album.nure.ua/service", className = "ua.nure.album.service.GetImageByUrl")
    @ResponseWrapper(localName = "getImageByUrlResponse", targetNamespace = "http://album.nure.ua/service", className = "ua.nure.album.service.GetImageByUrlResponse")
    @Action(input = "http://album.nure.ua/service/AlbumService/getImageByUrlRequest", output = "http://album.nure.ua/service/AlbumService/getImageByUrlResponse")
    public Image getImageByUrl(
        @WebParam(name = "imgUrl", targetNamespace = "")
        String imgUrl);

    /**
     * 
     * @param imgUrl
     * @param albumId
     */
    @WebMethod
    @RequestWrapper(localName = "removeImage", targetNamespace = "http://album.nure.ua/service", className = "ua.nure.album.service.RemoveImage")
    @ResponseWrapper(localName = "removeImageResponse", targetNamespace = "http://album.nure.ua/service", className = "ua.nure.album.service.RemoveImageResponse")
    @Action(input = "http://album.nure.ua/service/AlbumService/removeImageRequest", output = "http://album.nure.ua/service/AlbumService/removeImageResponse")
    public void removeImage(
        @WebParam(name = "albumId", targetNamespace = "")
        int albumId,
        @WebParam(name = "imgUrl", targetNamespace = "")
        String imgUrl);

    /**
     * 
     * @param image
     * @param albumId
     */
    @WebMethod
    @RequestWrapper(localName = "addImage", targetNamespace = "http://album.nure.ua/service", className = "ua.nure.album.service.AddImage")
    @ResponseWrapper(localName = "addImageResponse", targetNamespace = "http://album.nure.ua/service", className = "ua.nure.album.service.AddImageResponse")
    @Action(input = "http://album.nure.ua/service/AlbumService/addImageRequest", output = "http://album.nure.ua/service/AlbumService/addImageResponse")
    public void addImage(
        @WebParam(name = "albumId", targetNamespace = "")
        int albumId,
        @WebParam(name = "Image", targetNamespace = "http://album.nure.ua/entity")
        Image image);

    /**
     * 
     * @return
     *     returns java.util.List<ua.nure.album.entity.Album>
     */
    @WebMethod
    @WebResult(name = "listAlbums", targetNamespace = "http://album.nure.ua/entity")
    @RequestWrapper(localName = "listAlbums", targetNamespace = "http://album.nure.ua/service", className = "ua.nure.album.service.ListAlbums")
    @ResponseWrapper(localName = "listAlbumsResponse", targetNamespace = "http://album.nure.ua/service", className = "ua.nure.album.service.ListAlbumsResponse")
    @Action(input = "http://album.nure.ua/service/AlbumService/listAlbumsRequest", output = "http://album.nure.ua/service/AlbumService/listAlbumsResponse")
    public List<Album> listAlbums();

    /**
     * 
     * @param album
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "http://album.nure.ua/entity")
    @RequestWrapper(localName = "addAlbum", targetNamespace = "http://album.nure.ua/service", className = "ua.nure.album.service.AddAlbum")
    @ResponseWrapper(localName = "addAlbumResponse", targetNamespace = "http://album.nure.ua/service", className = "ua.nure.album.service.AddAlbumResponse")
    @Action(input = "http://album.nure.ua/service/AlbumService/addAlbumRequest", output = "http://album.nure.ua/service/AlbumService/addAlbumResponse")
    public int addAlbum(
        @WebParam(name = "Album", targetNamespace = "http://album.nure.ua/entity")
        Album album);

}
