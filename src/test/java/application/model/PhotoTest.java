package application.model;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PhotoTest {

    public Photo photo2 = new Photo();//Just to hit 100 percent coverage
    public Photo photo = new Photo(1, 1, "title", "url", "thumbnailUrl");


    @Test
    void getAlbumId() {
        //Arrange
        int expected = 1;


        //Act
        int actual = photo.getAlbumId();


        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void setAlbumId() {
        //Arrange
        int expected = 100;
        photo.setAlbumId(expected);


        //Act
        int actual = photo.getAlbumId();


        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getId() {
        //Arrange
        int expected = 1;


        //Act
        int actual = photo.getId();


        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void setId() {
        //Arrange
        int expected = 100;
        photo.setId(expected);


        //Act
        int actual = photo.getId();


        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getTitle() {
        //Arrange
        String expected = "title";


        //Act
        String actual = photo.getTitle();


        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void setTitle() {
        //Arrange
        String expected = "title test";
        photo.setTitle(expected);


        //Act
        String actual = photo.getTitle();


        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getUrl() {
        //Arrange
        String expected = "url";


        //Act
        String actual = photo.getUrl();


        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void setUrl() {
        //Arrange
        String expected = "url test";
        photo.setUrl(expected);


        //Act
        String actual = photo.getUrl();


        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getThumbnailUrl() {
        //Arrange
        String expected = "thumbnailUrl";


        //Act
        String actual = photo.getThumbnailUrl();


        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void setThumbnailUrl() {
        //Arrange
        String expected = "thumbnail test";
        photo.setThumbnailUrl(expected);


        //Act
        String actual = photo.getThumbnailUrl();


        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        //Arrange
        String expected = "[" + photo.getAlbumId() + "] " + photo.getTitle();


        //Act
        String actual = photo.toString();


        //Assert
        assertEquals(expected, actual);
    }
}