package application.services;

import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConnectionServiceTest {

    @Test
    void testSetupConnection() throws MalformedURLException {
        //Arrange
        ConnectionService connectionService = new ConnectionService();
//        when(connectionService.setupConnection()).thenCallRealMethod();
        String expectedRequestMEthod = "GET";
        int expectedTimeout = 5000;


        //Act
        HttpURLConnection urlConnection = connectionService.setupConnection();


        //Assert
        assertEquals(expectedRequestMEthod, urlConnection.getRequestMethod());
        assertEquals(expectedTimeout, urlConnection.getConnectTimeout());
        assertEquals(expectedTimeout, urlConnection.getReadTimeout());
    }
}