package ua.nure.album.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import ua.nure.album.entity.Album;
import ua.nure.album.entity.Image;

import java.sql.SQLException;
import java.util.Collection;

@WebService(targetNamespace= Const.SERVICE_NS)
    public interface AlbumService {
    @WebMethod()
    @WebResult(targetNamespace="http://album.nure.ua/entity")
    public int addAlbum(
            @WebParam(name="Album", targetNamespace="http://album.nure.ua/entity")
            Album album);

    @WebMethod()
    public void addImage(
            @WebParam(name = "albumId")
            int albumId,
            @WebParam(name="Image", targetNamespace="http://album.nure.ua/entity")
            Image image);

    @WebMethod()
    @WebResult(name="listAlbums", targetNamespace="http://album.nure.ua/entity")
    public Collection<Album> listAlbums();

    @WebMethod()
    @WebResult(name = "Image", targetNamespace = "http://album.nure.ua/entity")
    public Image getImageByUrl(
            @WebParam(name="imgUrl")
            String imgUrl);

    @WebMethod()
    public void removeImage(
            @WebParam(name="albumId")
            int albumId,
            @WebParam(name="imgUrl")
            String imgUrl);
}