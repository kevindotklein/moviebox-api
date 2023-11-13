package app.moviebox.media.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MediaType {
    movies("movies"),
    series("series");

    private final String name;
}
