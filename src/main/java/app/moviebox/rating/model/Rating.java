package app.moviebox.rating.model;

import app.moviebox.media.model.Media;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

    private String text;
    private String stars;

    public Rating() {
        this.id = UUID.randomUUID();
    }
}
