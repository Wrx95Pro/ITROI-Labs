package ua.nure.album.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.album.entity.Album;
import ua.nure.album.entity.Author;
import ua.nure.album.entity.Image;
import ua.nure.album.service.AlbumService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddAlbum extends HttpServlet {
    private static final String DEBUG_ERROR_MSG = "Set errorMsg to the session";
    private static final long serialVersionUID = 1L;
    private final transient Logger log = LoggerFactory.getLogger(AddAlbum.class);

    private transient AlbumService service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (AlbumService) ctx.getAttribute("AlbumService");
        log.trace("Get attribute AlbumService : {}",service);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Album album = new Album();
        HttpSession session = request.getSession();
        String errMsg = null;

        try {
            album.setHeader(request.getParameter("header"));
            album.setText(request.getParameter("text"));
            album.setAccessLevel(request.getParameter("accessLevel"));
            album.setDate(request.getParameter("date"));

            Author author = new Author();
            author.setUsername(request.getParameter("username"));

            album.setCreatedBy(author);

            int countImages = Integer.parseInt(request.getParameter("countImages"));
            List<Image> images = new ArrayList<>();

            for (int i = 1; i <= countImages; i++) {
                String imageUrl = request.getParameter("imageUrl" + i);
                Image image = new Image();
                image.setImageUrl(imageUrl);
                images.add(image);
            }

            album.getImage().addAll(images);

            // ----------------------------
            // TO DO: Validate album
            // ----------------------------

            // Send request to web-service to add the album
            int id = service.addAlbum(album);

            // If successful, set the album into session attribute
            session.setAttribute("album", album);
        } catch (Exception e) {
            // Handle exceptions
            errMsg = "Error: Cannot communicate with the album service";
            log.debug(DEBUG_ERROR_MSG, e);
        }

        if (errMsg != null) {
            session.setAttribute("errorMsg", errMsg);
        }

        // PRG pattern
        response.sendRedirect("viewalbum.jsp");
        log.debug("Redirect to viewalbum.jsp");
    }


}
