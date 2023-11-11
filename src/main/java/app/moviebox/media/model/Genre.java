package app.moviebox.media.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Genre {
    HORROR("HORROR"),
    ROMANCE("ROMANCE"),
    ACTION("ACTION"),
    ADVENTURE("ADVENTURE"),
    ANIMATION("ANIMATION"),
    DOCUMENTARY("DOCUMENTARY"),
    DRAMA("DRAMA"),
    FANTASY("FANTASY"),
    MUSIC("MUSIC");

    private final String name;
}
