package app.moviebox.common.exception;

import lombok.Getter;

@Getter
public class ForbiddenAccessException extends RuntimeException{

    private final String message;

    public ForbiddenAccessException(String message) {
        super(message);
        this.message = message;
    }
}
