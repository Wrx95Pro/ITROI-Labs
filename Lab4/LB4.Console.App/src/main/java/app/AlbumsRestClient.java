package app;

import app.additions.ReturnsAtomic;
import app.entity.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import album.service.Constants;
import album.service.rest.JAXBContextProvider;
import album.service.rest.JSONMessageBodyReader;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class AlbumsRestClient extends Application {

    private static final URI BASE_URI = URI.create(Constants.SERVICE_BASE_URL);

    private static void printMenu() {
        System.out.println("1. Add album\n" +
                "2. Add image\n" +
                "3. Get list of albums\n" +
                "4. Get image by URL\n" +
                "5. Remove image\n" +
                "6. Exit\n");
    }

    private static void listAlbums(Client client) throws Exception {
        WebTarget target = client.target(BASE_URI + "/listAlbums");
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response resp = request.get();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var albums = resp.readEntity(Album[].class);
            for (Album album : albums) {
                System.out.println(album.toString());
            }
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static void addAlbum(Client client) throws Exception {
        Scanner scanner = new Scanner(System.in);
        var album = new Album();

        System.out.println("Enter album header: ");
        String header = scanner.nextLine();
        System.out.println("Enter album text: ");
        String text = scanner.nextLine();
        System.out.println("Enter album date: ");
        String date = scanner.nextLine();
        album.setHeader(header);
        album.setText(text);
        album.setDate(date);

        WebTarget target = client.target(BASE_URI + "/addAlbum");
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<Album> payload = jakarta.ws.rs.client.Entity.json(album);
        Response resp = request.post(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body1 = resp.readEntity(ReturnsAtomic.class);
            System.out.println("id = " + body1.getItem());
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static void addImage(Client client) throws Exception {
        Scanner scanner = new Scanner(System.in);
        var image = new Image();
        System.out.println("Enter album ID: ");
        int albumId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter image URL: ");
        String imageUrl = scanner.nextLine();

        WebTarget target = client.target(BASE_URI + "/addImage");
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<Image> payload = jakarta.ws.rs.client.Entity.json(image);
        Response resp = request.post(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body1 = resp.readEntity(ReturnsAtomic.class);
            System.out.println("id = " + body1.getItem());
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static void getImageByUrl(Client client, Scanner scanner) throws Exception {
        System.out.println("Enter image URL: ");
        String imageUrl = scanner.nextLine();
        WebTarget target = client.target(BASE_URI).path("search").queryParam("pattern", imageUrl);
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response resp = request.get();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body = resp.readEntity(Album[].class);
            for (Album album : body) {
                System.out.println(album.toString());
            }
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static void removeImage(Client client, Scanner scanner) throws Exception {
        System.out.println("Enter album ID: ");
        int albumId = Integer.parseInt(scanner.nextLine());
        WebTarget target = client.target(BASE_URI + "/removeImage");
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<Integer> payload = jakarta.ws.rs.client.Entity.json(albumId);
        Response resp = request.post(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            System.out.println("remove successful");
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        client
            .register(JSONMessageBodyReader.class)
            .register(JAXBContextProvider.class);

        Scanner sc = new Scanner(System.in);
        printMenu();
        while (true) {
            int choise = Integer.valueOf(sc.nextLine());
            try {
                switch (choise) {
                    case 1 -> {
                        addAlbum(client);
                        break;
                    }
                    case 2 -> {
                        addImage(client);
                        break;
                    }
                    case 3 -> {
                        listAlbums(client);
                        break;
                    }
                    case 4 -> {
                        getImageByUrl(client, sc);
                        break;
                    }
                    case 5 -> {
                        removeImage(client, sc);
                        break;
                    }


                    case 6 -> {
                        return;
                    }
                    default -> {
                        System.out.println("Invalid option");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("[Error] " + e.getMessage());
                e.printStackTrace();
            }
            printMenu();
        }
    }

    private static GregorianCalendar convertToGregorianCalendar(String dateString) throws ParseException, DatatypeConfigurationException {
        SimpleDateFormat dateFormat;

        if (dateString.length() <= 10) { // If input contains only date (without time)
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        Date date = dateFormat.parse(dateString);

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);

        return cal;
    }

    private static XMLGregorianCalendar convertToXMLGregorianCalendar(GregorianCalendar calendar) throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    }
}
