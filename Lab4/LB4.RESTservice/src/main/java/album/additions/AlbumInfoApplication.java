package album.additions;

import album.service.AlbumServiceRestImpl;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

public class AlbumInfoApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(AlbumServiceRestImpl.class);

        return classes;
    }
}
