package ua.nure.album.dao;

import ua.nure.dbtable.DBTable;
import ua.nure.dbtable.DBTableFactory;
import ua.nure.dbtable.Filter;
import ua.nure.album.entity.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;

public class AlbumDAOInMemoryImpl implements AlbumDAO {
    DBTable<Album> albums = DBTableFactory.instance();

    private static AlbumDAOInMemoryImpl instance;


    private AlbumDAOInMemoryImpl() {
        initAlbums();
    }

    public static synchronized AlbumDAOInMemoryImpl instance() {
        if (instance == null) {
            instance = new AlbumDAOInMemoryImpl();
        }
        return instance;
    }

    private Album newAlbum(String header, String text, String date, Collection<Image> image, Author author, AccessLevel accessLevel) {
        var album = new Album();
        album.setHeader(header);
        album.setText(text);
        album.setDate(date);
        album.getImage().addAll(image);
        album.setCreatedBy(author);
        album.setAccessLevel(accessLevel);

        return album;
    }

    private Author newAuthor(String username) {
        Author author = new Author();
        author.setUsername(username);

        return author;
    }

    private Image newImage(String image_url) {
        Image image = new Image();
        image.setImageUrl(image_url);

        return image;
    }


    private void initAlbums() {
        Album[] albums = new Album[]{
                newAlbum("Summer 2019",
                        "from the good times",
                        "August 2019",
                        Arrays.asList(newImage("res/summer19/img1.jpg"), newImage("dfg")),
                        newAuthor("@longusername"),
                        AccessLevel.PUBLIC
                ),
                newAlbum("Summer 2019",
                        "from the good times",
                        "August 2019",
                        Arrays.asList(newImage("res/summer19/img1.jpg"), newImage("dfg")),
                        newAuthor("@longusername"),
                        AccessLevel.PUBLIC
                ),
                newAlbum("Summer 2019",
                        "from the good times",
                        "August 2019",
                        Arrays.asList(newImage("res/summer19/img1.jpg"), newImage("dfg")),
                        newAuthor("@longusername"),
                        AccessLevel.PUBLIC
                ),
        };
        for (int i = 0; i < albums.length; i++) {
            addAlbum(albums[i]);
        }
    }

    @Override
    public Collection<Album> listAlbums() {
        return this.albums.selectAll();
    }

    @Override
    public Image getImageByUrl(String imgUrl) {
        for (var film : this.albums.selectAll()) {
            for (var image : film.getImage()) {
                if (image.getImageUrl().equals(imgUrl)) {
                    return image;
                }
            }
        }

        return null;
    }

    @Override
    public int addAlbum(Album album) {
        int id = this.albums.insert(album);
        album.setId(id);

        this.albums.update(id, album);

        return id;
    }


    @Override
    public void addImage(int albumId, Image image) {
        Album album = null;
        try {
            album = this.albums.get(albumId);
            album.getImage().add(image);
            this.albums.update(albumId, album);
        } catch (SQLException e) {
            //
        }
    }

    @Override
    public void removeImage(int albumId, String imgUrl) {
        for (Album album : this.albums.selectAll()) {
            if (album.getId() == albumId) {
                for (Image image : album.getImage()) {
                    if (image.getImageUrl().equals(imgUrl)) {
                        album.getImage().remove(image);
                        this.albums.update(albumId, album);
                    }
                }
            }
        }
    }
}
