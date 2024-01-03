package ua.nure.album.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.album.entity.Album;
import ua.nure.album.service.AlbumService;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ListAlbums
 */
public class ListAlbums extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(ListAlbums.class);

	private AlbumService service;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (AlbumService) ctx.getAttribute("AlbumService");
		log.trace("Get attribute AlbumService : {}",service);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Album> albums = service.listAlbums();
		log.debug("Get albums from AlbumService : {}", albums);
		request.setAttribute("albums", albums);
		log.trace("Set albums to the session : {}", albums);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		log.trace("Redirect to list.jsp");
	}

}
