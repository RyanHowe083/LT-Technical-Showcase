package application.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;

@Service
public class ResponseService {

    public ResponseService(){}

    public List<String> getResponse(HttpURLConnection httpURLConnection){
        try{
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = (new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            //Couldn't split by ',' so this gives a delimiter between each json string
            String placeHolder = stringBuilder.toString().replaceAll("},","}delim").replace('[',' ').replace(']',' ');
            return Arrays.asList(placeHolder.split("delim"));
        }catch (IOException exception){
            System.err.println(exception.getMessage());
        }
        return null;
    }
}
