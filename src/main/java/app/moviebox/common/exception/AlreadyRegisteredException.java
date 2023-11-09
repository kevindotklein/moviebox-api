package app.moviebox.common.exception;

import lombok.Getter;

@Getter
public class AlreadyRegisteredException extends RuntimeException{

    private final String message;

    public AlreadyRegisteredException(String message) {
        super(message);
        this.message = message;
    }
}
