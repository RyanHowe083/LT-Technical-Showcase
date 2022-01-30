package application.processor;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PhotoAlbumProcessorTest {
    @Test
    void test(){
        assertTrue(true);

    }

//    @Test
//    void testProcessAlbumRequests_whenInputNegativeThenReturnMinusOneFlag() {
//        //Arrange
//        PhotoAlbumProcessor photoAlbumProcessor = mock(PhotoAlbumProcessor.class);
//        Long expected = -1L;
//        String negativeInput = "-1";
//        when(photoAlbumProcessor.getUserInput()).thenReturn(negativeInput);
//        when(photoAlbumProcessor.processAlbumRequests()).thenCallRealMethod();
//        when(photoAlbumProcessor.processUserInput()).thenCallRealMethod();
//
//        //Act
//        Long actual = photoAlbumProcessor.processAlbumRequests();
//
//        //Assert
//        assertEquals(expected,actual);
//    }
//
//    @Test
//    void testProcessAlbumRequests_whenNotNumericThenReturnMinusOneFlag() {
//        //Arrange
//        PhotoAlbumProcessor photoAlbumProcessor = mock(PhotoAlbumProcessor.class);
//        Long expected = -1L;
//        String negativeInput = "abc";
//        when(photoAlbumProcessor.getUserInput()).thenReturn(negativeInput);
//        when(photoAlbumProcessor.processAlbumRequests()).thenCallRealMethod();
//        when(photoAlbumProcessor.processUserInput()).thenCallRealMethod();
//
//        //Act
//        Long actual = photoAlbumProcessor.processAlbumRequests();
//
//        //Assert
//        assertEquals(expected,actual);
//    }
//
//    @Ignore
//    @Test
//    void testProcessAlbumRequests_whenInputIsNullThenReturnMinusOneFlag() {
//        //Arrange
//        PhotoAlbumProcessor photoAlbumProcessor = mock(PhotoAlbumProcessor.class);
//        Long expected = -1L;
//        String negativeInput = "";
//        when(photoAlbumProcessor.getUserInput()).thenReturn(negativeInput);
//        when(photoAlbumProcessor.processAlbumRequests()).thenCallRealMethod();
//        when(photoAlbumProcessor.processUserInput()).thenCallRealMethod();
//
//        //Act
//        Long actual = photoAlbumProcessor.processAlbumRequests();
//
//        //Assert
//        assertEquals(expected,actual);
//    }
//
//    @Test
//    void testProcessAlbumRequests_whenInputQThenThrowException() {
//        //Arrange
//        PhotoAlbumProcessor photoAlbumProcessor = mock(PhotoAlbumProcessor.class);
//        Long expected = null;
//        String negativeInput = "q";
//        when(photoAlbumProcessor.getUserInput()).thenReturn(negativeInput);
//        when(photoAlbumProcessor.processAlbumRequests()).thenCallRealMethod();
//        when(photoAlbumProcessor.processUserInput()).thenCallRealMethod();
//
//        //Act
////        Long actual = photoAlbumProcessor.processAlbumRequests();
//        NullPointerException nullPointerException = assertThrows(NullPointerException.class,() -> {
//            photoAlbumProcessor.processAlbumRequests();
//        });
//
//        //Assert
//        assertNotEquals(nullPointerException, null);
//    }
//
//    @Test
//    void testProcessAlbumRequests_whenInputGoodThenReturnInput() {
//        //Arrange
//        PhotoAlbumProcessor photoAlbumProcessor = mock(PhotoAlbumProcessor.class);
//        Long expected = 10L;
//        String input = "10L";
//        when(photoAlbumProcessor.getUserInput()).thenReturn(input);
//        when(photoAlbumProcessor.processAlbumRequests()).thenCallRealMethod();
//        when(photoAlbumProcessor.processUserInput()).thenReturn(expected);
//
//        //Act
//        Long actual = photoAlbumProcessor.processAlbumRequests();
//
//        //Assert
//        assertEquals(expected, actual);
//    }
}