package app.moviebox.movie.model;

import app.moviebox.media.model.Media;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie extends Media {

    private String duration;
}
