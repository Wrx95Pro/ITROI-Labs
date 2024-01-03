package ua.nure.album.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.album.entity.Image;
import ua.nure.album.service.AlbumService;

import java.io.IOException;

/**
 * Servlet implementation class GetImageByUrl
 */
public class GetImageByUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(GetImageByUrl.class);

	private AlbumService service;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (AlbumService) ctx.getAttribute("AlbumService");
		log.trace("Get attribute AlbumService: {}", service);
	}


    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pattern = request.getParameter("imageUrl");
		log.debug("Get find pattern from request : {}",pattern);
        HttpSession session = request.getSession();

		Image image = service.getImageByUrl(pattern);
		log.debug("Get image from AlbumsService : {}", image);
        session.setAttribute("image", image);
		log.trace("Set image to the session : {}",image);
        // PRG pattern
        response.sendRedirect("viewimage.jsp");
        log.debug("Redirect to viewimage.jsp");
	}
}
