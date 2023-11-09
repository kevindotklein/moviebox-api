package app.moviebox.media.model;

import app.moviebox.rating.model.Rating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@AllArgsConstructor
public class Media {

    @Id
    private UUID id;

    private String name;
    private String cover;
    private String description;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String director;

    private String year;

    @OneToMany(mappedBy = "media", fetch = FetchType.EAGER)
    private List<Rating> ratings;

    public Media() {
        this.id = UUID.randomUUID();
    }
}
