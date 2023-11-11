package app.moviebox.movie.dto;

import app.moviebox.media.model.Genre;
import jakarta.validation.constraints.NotBlank;

public record MovieRequest(@NotBlank String name,
                           @NotBlank String cover,
                           @NotBlank String description,
                           Genre genre,
                           @NotBlank String director,
                           @NotBlank String year,
                           @NotBlank String duration) {
}
