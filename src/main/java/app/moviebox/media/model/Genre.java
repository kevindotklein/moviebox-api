package app.moviebox.media.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Genre {
    HORROR("HORROR"),
    ROMANCE("ROMANCE");

    private final String name;
}
