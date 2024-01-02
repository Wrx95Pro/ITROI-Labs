package album.service;

import album.dao.AlbumDAO;
import album.dao.AlbumDAOInMemoryImpl;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

public class AlbumSearcher {
    private AlbumDAO store = AlbumDAOInMemoryImpl.instance();
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void search(@QueryParam("pattern") String pattern) {
        System.out.println("search for Albums: " + pattern);
    }
}
