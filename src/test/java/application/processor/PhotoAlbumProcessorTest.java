package application.processor;

import application.PhotoAlbumApplication;
import application.services.ConnectionService;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PhotoAlbumProcessorTest {

    @Test
    void testProcessAlbumRequests_whenInputGoodThenReturnInput() {
        //Arrange
        PhotoAlbumProcessor photoAlbumProcessor = mock(PhotoAlbumProcessor.class);
        Long expected = 10L;
        String input = "10L";
        when(photoAlbumProcessor.getUserInput()).thenReturn(input);
        when(photoAlbumProcessor.processAlbumRequests()).thenCallRealMethod();
        when(photoAlbumProcessor.processUserInput()).thenReturn(expected);

        //Act
        Long actual = photoAlbumProcessor.processAlbumRequests();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void testProcessAlbumRequests_whenUserInputNullReturnExitCode() {
        //Arrange
        PhotoAlbumProcessor photoAlbumProcessor = mock(PhotoAlbumProcessor.class);
        when(photoAlbumProcessor.processUserInput()).thenReturn(null);
        when(photoAlbumProcessor.processAlbumRequests()).thenCallRealMethod();

        Long expected = PhotoAlbumApplication.EXIT_CODE;

        //Act
        long actual = photoAlbumProcessor.processAlbumRequests();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void testProcessAlbumRequests_whenUserInputNonNumericalReturnExitCode() {
        //Arrange
        PhotoAlbumProcessor photoAlbumProcessor = mock(PhotoAlbumProcessor.class);
        when(photoAlbumProcessor.getUserInput()).thenReturn("ABC");
        when(photoAlbumProcessor.processUserInput()).thenCallRealMethod();
        when(photoAlbumProcessor.processAlbumRequests()).thenCallRealMethod();

        Long expected = PhotoAlbumApplication.EXIT_CODE;

        //Act
        long actual = photoAlbumProcessor.processAlbumRequests();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void testProcessAlbumRequests_whenUserInputNegativeReturnExitCode() {
        //Arrange
        PhotoAlbumProcessor photoAlbumProcessor = mock(PhotoAlbumProcessor.class);
        when(photoAlbumProcessor.getUserInput()).thenReturn("-5");
        when(photoAlbumProcessor.processUserInput()).thenCallRealMethod();
        when(photoAlbumProcessor.processAlbumRequests()).thenCallRealMethod();

        Long expected = PhotoAlbumApplication.EXIT_CODE;

        //Act
        long actual = photoAlbumProcessor.processAlbumRequests();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void processConnection() throws IOException {
        //Arrange
        PhotoAlbumProcessor photoAlbumProcessor = mock(PhotoAlbumProcessor.class);
        ConnectionService connectionService = new ConnectionService();

        when(photoAlbumProcessor.processConnection()).thenReturn(connectionService.setupConnection());

        HttpURLConnection httpURLConnection = photoAlbumProcessor.processConnection();
        String expectedResquestMethod = "GET";
        int expectedTimeout = 5000;


        //Act
        String actualResquestMethod = httpURLConnection.getRequestMethod();
        int actualReadTimeout = httpURLConnection.getReadTimeout();
        int actualConnectTimeout = httpURLConnection.getConnectTimeout();


        //Assert
        assertEquals(expectedResquestMethod, actualResquestMethod);
        assertEquals(expectedTimeout, actualConnectTimeout);
        assertEquals(expectedTimeout, actualReadTimeout);
    }
}