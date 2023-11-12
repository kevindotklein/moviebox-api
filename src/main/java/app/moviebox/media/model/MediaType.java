package app.moviebox.media.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MediaType {
    movie("movie"),
    series("series");

    private final String name;
}
