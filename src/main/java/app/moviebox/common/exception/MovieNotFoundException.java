package app.moviebox.common.exception;

import lombok.Getter;

@Getter
public class MovieNotFoundException extends RuntimeException{

    private final String message;

    public MovieNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
