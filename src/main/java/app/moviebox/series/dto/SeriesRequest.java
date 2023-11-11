package app.moviebox.series.dto;

import app.moviebox.media.model.Genre;
import jakarta.validation.constraints.NotBlank;

public record SeriesRequest(@NotBlank String name,
                            @NotBlank String cover,
                            @NotBlank String description,
                            Genre genre,
                            @NotBlank String director,
                            @NotBlank String year,
                            @NotBlank String episodes,
                            @NotBlank String seasons) {
}
