package app.moviebox.rating.model;

import app.moviebox.media.model.Media;
import app.moviebox.movie.model.Movie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@AllArgsConstructor
public class Rating {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Media media;

    private String comment;
    private String stars;
    private Instant createdAt;

    public Rating() {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
    }

    public Rating(String comment, String stars, Media media) {
        this.id = UUID.randomUUID();
        this.comment = comment;
        this.stars = stars;
        this.media = media;
        this.createdAt = Instant.now();
    }
}
