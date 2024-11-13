package lbx.org.qa.example.exceptions;

import java.time.format.DateTimeParseException;

public class InvalidDateFormatException extends RuntimeException {
    public InvalidDateFormatException(String message, DateTimeParseException e) {
        super(message,e);
    }
}
