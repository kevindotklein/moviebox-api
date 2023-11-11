package app.moviebox.common.exception;

import lombok.Getter;

@Getter
public class SeriesNotFoundException extends RuntimeException{

    private final String message;

    public SeriesNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
