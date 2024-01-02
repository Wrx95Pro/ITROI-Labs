package ua.nure.album;

import jakarta.xml.ws.Endpoint;
import ua.nure.album.service.AlbumServiceImpl;

import java.util.Scanner;

public class AlbumServer {
    public static final Object implementor = new AlbumServiceImpl();
    public static final String ADDRESS = "http://localhost:9000/albums";

    public static void main(String[] args) {
        System.out.println("Starting Server");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        Endpoint endpoint = Endpoint.publish(ADDRESS, implementor);

        System.out.println("Server ready... at " + ADDRESS);

        System.err.println("Press <enter> to stop service... ");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        sc.close();
        endpoint.stop();
        System.out.println("Server exit");
    }
}
