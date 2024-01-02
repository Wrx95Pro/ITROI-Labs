package album.service;

import album.entity.Image;

public class AddImageRequest {
    private int albumId;
    private Image image;

    // Default constructor
    public AddImageRequest() {
    }

    // Constructor with parameters
    public AddImageRequest(int albumId, Image image) {
        this.albumId = albumId;
        this.image = image;
    }

    // Getter and setter methods for albumId
    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    // Getter and setter methods for image
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
