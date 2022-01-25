package showcase.photoalbum;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhotoAlbumApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(PhotoAlbumApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running Spring Boot Application");
    }

}
