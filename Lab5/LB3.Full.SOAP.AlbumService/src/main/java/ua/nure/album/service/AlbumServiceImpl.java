package ua.nure.album.service;

import jakarta.jws.WebService;
import ua.nure.album.dao.DAOException;
import ua.nure.album.entity.Album;
import ua.nure.album.dao.AlbumDAO;
import ua.nure.album.dao.AlbumDAOInMemoryImpl;
import ua.nure.album.entity.Image;

import java.sql.SQLException;
import java.util.Collection;

@WebService(serviceName="Album",
        portName="AlbumPort",
        endpointInterface="ua.nure.album.service.AlbumService",
        targetNamespace="http://album.nure.ua/service")
public class AlbumServiceImpl implements AlbumService {

    private static AlbumDAO albumDAO = AlbumDAOInMemoryImpl.instance();


    @Override
    public int addAlbum(Album album) {
        return albumDAO.addAlbum(album);
    }

    @Override
    public void addImage(int albumId, Image image) {
        albumDAO.addImage(albumId, image);
    }

    @Override
    public Collection<Album> listAlbums() {
        return albumDAO.listAlbums();
    }

    @Override
    public Image getImageByUrl(String imgUrl) {
        return albumDAO.getImageByUrl(imgUrl);
    }

    @Override
    public void removeImage(int albumId, String imgUrl) {
        albumDAO.removeImage(albumId, imgUrl);
    }
}
