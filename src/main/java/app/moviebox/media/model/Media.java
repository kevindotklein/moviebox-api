package app.moviebox.media.model;

import app.moviebox.rating.model.Rating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "medias")
@Inheritance(strategy = InheritanceType.JOINED)
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

    @OneToMany(mappedBy = "media", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rating> ratings;

    public Media() {
        this.id = UUID.randomUUID();
    }

    public Media(String name, String cover, String description, Genre genre, String director, String year) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cover = cover;
        this.description = description;
        this.genre = genre;
        this.director = director;
        this.year = year;
    }
}
