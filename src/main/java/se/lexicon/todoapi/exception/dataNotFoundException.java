package se.lexicon.todoapi.exception;

public class dataNotFoundException extends RuntimeException{

    public dataNotFoundException() {
    }

    public dataNotFoundException(String message) {
        super(message);
    }

    public dataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public dataNotFoundException(Throwable cause) {
        super(cause);
    }

    public dataNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
