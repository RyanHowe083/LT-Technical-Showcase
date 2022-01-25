package showcase.photoalbum;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class PhotoAlbumApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(PhotoAlbumApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running Spring Boot Application");


        URL url = new URL("https://jsonplaceholder.typicode.com/photos");
        URLConnection urlConnection = url.openConnection();
        System.out.println(urlConnection.getContent());
    }

}
