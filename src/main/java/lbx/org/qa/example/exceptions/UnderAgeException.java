package lbx.org.qa.example.exceptions;

public class UnderAgeException extends RuntimeException {

    public UnderAgeException(String message) {
        super(message);
    }

    public UnderAgeException(String message, Throwable e) {
        super(message, e);
    }
}
