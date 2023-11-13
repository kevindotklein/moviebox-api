package app.moviebox.rating.model;

import app.moviebox.media.model.Media;
import app.moviebox.user.model.User;
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

    @ManyToOne(fetch = FetchType.EAGER)
    private Media media;

    private String comment;
    private String stars;
    private Instant createdAt;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private User user;

    public Rating() {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
    }

    public Rating(String comment, String stars, Media media, User user) {
        this.id = UUID.randomUUID();
        this.comment = comment;
        this.stars = stars;
        this.media = media;
        this.createdAt = Instant.now();
        this.user = user;
    }

}
