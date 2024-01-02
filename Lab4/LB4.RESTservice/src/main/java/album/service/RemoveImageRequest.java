package album.service;

public class RemoveImageRequest {
    private int albumId;
    private String imgUrl;

    public RemoveImageRequest() {
    }

    public RemoveImageRequest(int albumId, String imgUrl) {
        this.albumId = albumId;
        this.imgUrl = imgUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
