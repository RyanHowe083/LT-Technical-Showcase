package application;

import application.processor.PhotoAlbumProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import application.model.Photo;
import application.services.ConnectionService;
import application.services.ResponseService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
