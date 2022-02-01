package application.processor;


import application.exceptions.InvalidInputException;
import application.model.Photo;
import application.services.ConnectionService;
import application.services.ResponseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhotoAlbumProcessor {

    private final ConnectionService connectionService = new ConnectionService();
    private final ResponseService responseService = new ResponseService();

    public PhotoAlbumProcessor() throws MalformedURLException {
    }

    public long processAlbumRequests() {
        System.out.println("Photo Album Application.");
        System.out.println("Enter q to end.");
        Long userInput = processUserInput();
        if (userInput == null || userInput.equals(-1L)) {
//            System.out.println("Invalid input: please enter a number between 1-100.");
            return -1;
        }
        return userInput;
    }

    public Long processUserInput() {
        Long inputFilter = null;
        try {
            String userInput = getUserInput();
            if (userInput != null && !userInput.equals("q")) {
                if (Long.parseLong(userInput) < 1 || Long.parseLong(userInput) > 100) {
//                    throw new InvalidInputException("Invalid input: please enter a number between 1-100");
                    return null;
                }
                inputFilter = Long.parseLong(userInput);
            }
        } catch (InvalidInputException exception) {
            System.err.println(exception.getMessage());
            return -1L;
        } catch (NumberFormatException exception) {
            System.err.println(exception.getMessage() + " Invalid input: please enter a number between 1-100.");
            return -1L;
        }
        return inputFilter;
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = null;
        System.out.println("Which album would you like displayed: ");
        userInput = scanner.next();
        return userInput;
    }

    public HttpURLConnection processConnection() throws IOException {
        return connectionService.setupConnection();
    }

    public List<String> processResponse(HttpURLConnection httpURLConnection) throws IOException {
        return responseService.getResponse(httpURLConnection);
    }

    public List<Photo> processObjectMapper(List<String> response, long albumIdFilter) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Photo> photos = new ArrayList<>();

        response.forEach(s -> {
            try {
                Photo photo = objectMapper.readValue(s,Photo.class);
                if(photo.getAlbumId() == albumIdFilter){
                    photos.add(photo);
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return photos;
    }

    public void display(List<Photo> photos, long albumIdFilter) {
        System.out.println(">photo-album " + albumIdFilter);
        for(Photo photo : photos){
            System.out.println(photo.toString());
        }
    }
}
