package application.services;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ConnectionService {

    private static final String urlString = "https://jsonplaceholder.typicode.com/photos";
    private final URL url = new URL(urlString);

    public ConnectionService() throws MalformedURLException {
    }

    public HttpURLConnection setupConnection() {
        try{
            HttpURLConnection  urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            return urlConnection;
        }catch (IOException exception){
            System.err.println(exception.getMessage());
        }
        return null;
    }
}
