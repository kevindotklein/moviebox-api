package app.moviebox.media.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Genre {
    HORROR("Horror");

    private final String name;
}
