package album.service;

import com.sun.research.ws.wadl.Application;
import album.additions.ReturnsAtomic;
import album.dao.DAOException;
import album.dao.AlbumDAO;
import album.dao.AlbumDAOInMemoryImpl;
import album.entity.Album;
import album.entity.Image;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Path(Constants.ALBUMS_SERVICE_PATH)
public class AlbumServiceRestImpl extends Application {

    private static final long LONG_WORK_WAIT_TIMEOUT = 1000;

    private static final int DEFAULT_THREAD_POOL_SIZE = 10;

    private AlbumDAO store;

    ExecutorService executor = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE);

    private void log(String msg) {
        System.out.println(this.getClass().getSimpleName() + ": " + msg);
    }

    @PostConstruct
    public void init() {
        log("init");
        store = AlbumDAOInMemoryImpl.instance();
    }

    @PreDestroy
    public void destroy() {
        log("destroy");
        store = null;
        executor.shutdown();
    }

    @Path("listAlbums")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listAlbums() {
        log("all");
        var albums = this.store.listAlbums();
        System.out.println("getting all");
        return Response.ok(albums).build();
    }

    @Path("addAlbum")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ReturnsAtomic<Integer> addAlbum(Album album) throws DAOException {
        log("add album");
        var id = store.addAlbum(album);
        return new ReturnsAtomic<Integer>(id);
    }

    @Path("addImage")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addImage(AddImageRequest request) throws DAOException {
        log("add image");
        store.addImage(request.getAlbumId(), request.getImage());
    }

    @Path("getImageByUrl")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Image getImageByUrl(String imgUrl) throws DAOException {
        log("get image by url");
        return store.getImageByUrl(imgUrl);
    }

    @Path("removeImage")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeImage(RemoveImageRequest request) throws DAOException {
        log("delete image");
        store.removeImage(request.getAlbumId(), request.getImgUrl());
    }
}

