package app.moviebox.media.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MediaType {
    MOVIE("MOVIE"),
    SERIES("SERIES");

    private final String name;
}
