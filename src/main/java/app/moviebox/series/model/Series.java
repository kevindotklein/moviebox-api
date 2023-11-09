package app.moviebox.series.model;

import app.moviebox.media.model.Media;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "series")
@Getter
@Setter
public class Series extends Media {

    private String episodes;
    private String seasons;

}
