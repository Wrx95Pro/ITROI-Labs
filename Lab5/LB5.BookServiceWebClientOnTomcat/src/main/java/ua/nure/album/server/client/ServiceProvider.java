package ua.nure.album.server.client;

import ua.nure.album.service.Album;
import ua.nure.album.service.AlbumService;

import java.net.MalformedURLException;
import java.net.URL;

public class ServiceProvider {
	private static AlbumService albums;
	private static String url;
	
	protected ServiceProvider() {}
	
	private static AlbumService getDefaultAlbums() {
		Album port = new Album();
//		port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
		return port.getAlbumPort();
	}

	private static AlbumService getAlbums(String url) throws MalformedURLException {
		Album port = new Album(new URL(url));
//		port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
		return port.getAlbumPort();
	}
	
	public static synchronized AlbumService getInstance(String url) {
		if (albums == null) {
			if (url == null) {
				albums = getDefaultAlbums();
			} else {
				try {
					albums = getAlbums(url);
				} catch (MalformedURLException e) {
					albums = null;
				}
			}
		} else if (!url.equals(ServiceProvider.url)) {
			try {
				albums = getAlbums(url);
				ServiceProvider.url = url;
			} catch (MalformedURLException e) {
				ServiceProvider.url = null;
				albums = null;
			}
		}
		return albums;
	}
}
