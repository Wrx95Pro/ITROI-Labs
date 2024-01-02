import ua.nure.album.entity.Album;
import ua.nure.album.entity.Author;
import ua.nure.album.entity.Image;
import ua.nure.album.service.AlbumService;

import java.util.Collection;
import java.util.Scanner;

public class Main {
    private static final String CLIENT_TOKEN_VALID = "clientToken";
    private static String CLIENT_TOKEN = "clientToken";

    private static void printMenu() {
        System.out.println("1. Add album\n" +
                "2. Add image\n" +
                "3. Get list of albums\n" +
                "4. Get image by URL\n" +
                "5. Remove image\n" +
                "6. Exit\n");
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        AlbumService client = new ua.nure.album.service.Album().getAlbumPort();
        Scanner sc = new Scanner(System.in);
        printMenu();
        while (true) {
            int choise = Integer.valueOf(sc.nextLine());
            try {
                switch (choise) {
                    case 1 -> {
                        addAlbum(client, sc);
                        break;
                    }
                    case 2 -> {
                        addImage(client, sc);
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

    private static void addAlbum(AlbumService service, Scanner scanner) {
        Album album = new Album();

        // Create a Scanner object for user input
        //Scanner scanner = new Scanner(System.in);

        // Prompt the user for input and set values for Album properties
        System.out.println("Enter album header:");
        album.setHeader(scanner.nextLine());

        System.out.println("Enter album text:");
        album.setText(scanner.nextLine());

        System.out.println("Enter album date:");
        album.setDate(scanner.nextLine());

        // Handle multiple images
        System.out.println("Enter the number of images:");
        int numImages = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        for (int i = 0; i < numImages; i++) {
            System.out.println("Enter image URL " + (i + 1) + ":");
            String imageUrl = scanner.nextLine();

            // Create an Image object and add it to the album
            Image image = new Image();
            image.setImageUrl(imageUrl);
            album.getImage().add(image);
        }

        //System.out.println("Enter created by author:");
        Author author = new Author();
        System.out.println("Enter author name:");
        author.setUsername(scanner.nextLine());
        // Set other author properties as needed
        album.setCreatedBy(author);

        System.out.println("Enter access level:");
        album.setAccessLevel(scanner.nextLine());

        // Close the Scanner
        //scanner.close();
    }

    private static void addImage(AlbumService service, Scanner scanner) {
        var image = new Image();
        System.out.println("Enter album ID: ");
        int albumId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter image URL: ");
        String imageUrl = scanner.nextLine();
    }

    private static void getImageByUrl(AlbumService service, Scanner scanner) {
        System.out.println("Enter image URL: ");
        String imageUrl = scanner.nextLine();
        Image image = service.getImageByUrl(imageUrl);
        if (image != null) {
            System.out.println("Found image: " + image);
        } else {
            System.out.println("Image not found.");
        }
    }

    private static void removeImage(AlbumService service, Scanner scanner) {
        System.out.println("Enter album ID: ");
        int albumId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter image URL: ");
        String imageUrl = scanner.nextLine();
        service.removeImage(albumId, imageUrl);
        System.out.println("Image removed with URL: " + imageUrl);
    }

    private static void listAlbums(AlbumService service) {
        Collection<Album> albums = service.listAlbums();
        if (albums.isEmpty()) {
            System.out.println("No albums found.");
        } else {
            System.out.println("List of albums:");
            for (Album album : albums) {
                System.out.println(album);
            }
        }
    }
}
