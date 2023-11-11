package app.moviebox.movie.dto;

import app.moviebox.media.model.Genre;

import java.util.UUID;

public record MovieResponse(UUID id,
                            String name,
                            String cover,
                            String description,
                            Genre genre,
                            String director,
                            String year,
                            String duration) {
}
