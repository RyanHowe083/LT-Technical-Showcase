package application.services;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResponseServiceTest {

    @Test
    void testGetResponse() throws MalformedURLException {
        //Arrange
        ConnectionService connectionService = new ConnectionService();
        ResponseService responseService = new ResponseService();

        //Act
        List<String> actual = responseService.getResponse(connectionService.setupConnection());


        //Assert
        assertNotNull(actual);
    }
}