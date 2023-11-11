package app.moviebox.series.model;

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
@Table(name = "series")
@Getter
@Setter
@NoArgsConstructor
public class Series extends Media {

    private String episodes;
    private String seasons;

    public Series(UUID id, String name, String cover, String description, Genre genre,
                  String director, String year, List<Rating> ratings, String episodes, String seasons) {
        super(id, name, cover, description, genre, director, year, ratings);
        this.episodes = episodes;
        this.seasons = seasons;
    }
}
