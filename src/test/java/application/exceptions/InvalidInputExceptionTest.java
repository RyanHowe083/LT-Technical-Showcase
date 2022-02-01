package application.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidInputExceptionTest {

    InvalidInputException invalidInputException = new InvalidInputException("Test message");

    @Test
    void testInvalidInputExceptionConstructor(){
        assertNotNull(invalidInputException);
    }

}