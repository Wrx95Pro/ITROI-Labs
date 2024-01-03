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
 * Servlet implementation class AddComment
 */
public class AddImage extends HttpServlet {
    private static final String DEBUG_ERROR_MSG = "Set errorMsg to the session";
    private static final long serialVersionUID = 1L;
    private final transient Logger log = LoggerFactory.getLogger(AddImage.class);

    private transient AlbumService service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (AlbumService) ctx.getAttribute("AlbumService");
        log.trace("Get attribute AlbumService : {}", service);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int albumIdStr = Integer.parseInt(request.getParameter("albumId"));
        String imageUrl = request.getParameter("imageUrl");
        Image image = new Image();
        image.setImageUrl(imageUrl);
        HttpSession session = request.getSession();
        log.debug("Request encoding : {}", request.getCharacterEncoding());

        log.debug("Get image from request : {}", image);

        // ----------------------------
        // TO DO Validate image
        // ----------------------------

        // send request to web-service
        service.addImage(albumIdStr, image);
        log.debug("Image added");

        // if ok set book into session attribute
        session.setAttribute("image", image);


        // PRG pattern
        response.sendRedirect("viewimage.jsp");
        log.debug("Redirect to viewimage.jsp");
    }

}
