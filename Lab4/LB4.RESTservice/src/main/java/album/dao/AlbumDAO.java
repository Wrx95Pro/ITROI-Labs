package album.dao;

import album.entity.Album;
import album.entity.Image;

import java.awt.*;
import java.sql.SQLException;
import java.util.Collection;

public interface AlbumDAO {
    public Collection<Album> listAlbums();
    public Image getImageByUrl(String imgUrl);
    public int addAlbum(Album album);
    public void addImage(int albumId, Image image);
    public void removeImage(int albumId, String imgUrl);
}


/*

        Отримання списку альбомів - list albums
        Відображення фотографії у високій роздільній здатності - get image by id
        Створення нового альбому - add album
        Додавання фотографій до існуючого альбому - add image
        Видалення наявних фотографій з альбому. - remove image
*/
