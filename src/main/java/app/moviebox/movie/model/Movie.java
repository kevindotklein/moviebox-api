package app.moviebox.movie.model;

import app.moviebox.media.model.Genre;
import app.moviebox.media.model.Media;
import app.moviebox.rating.model.Rating;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
public class Movie extends Media {

    private String duration;

    public Movie(UUID id, String name, String cover, String description, Genre genre, String director,
                 String year, List<Rating> ratings, String duration) {
        super(id, name, cover, description, genre, director, year, ratings);
        this.duration = duration;
    }

    public Movie(String name, String cover, String description,
                 Genre genre, String director, String year, String duration) {
        super(name, cover, description, genre, director, year);
        this.duration = duration;
    }
}
