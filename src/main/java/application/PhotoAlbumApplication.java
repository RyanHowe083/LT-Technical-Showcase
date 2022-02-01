package application;

import application.model.Photo;
import application.processor.PhotoAlbumProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.HttpURLConnection;
import java.util.List;

@SpringBootApplication
public class PhotoAlbumApplication implements CommandLineRunner {

    public static final long EXIT_CODE = -1;

    public static void main(String[] args) {
        SpringApplication.run(PhotoAlbumApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PhotoAlbumProcessor photoAlbumProcessor = new PhotoAlbumProcessor();
        long albumIdFilter = photoAlbumProcessor.processAlbumRequests();
        while(albumIdFilter != EXIT_CODE){
            HttpURLConnection httpURLConnection = photoAlbumProcessor.processConnection();
            List<String> response = photoAlbumProcessor.processResponse(httpURLConnection);
            List<Photo> photos = photoAlbumProcessor.processObjectMapper(response, albumIdFilter);
            photoAlbumProcessor.display(photos, albumIdFilter);
            albumIdFilter = photoAlbumProcessor.processAlbumRequests();
        }
    }
}
