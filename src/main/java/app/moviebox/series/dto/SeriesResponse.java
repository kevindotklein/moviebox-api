package app.moviebox.series.dto;

import app.moviebox.media.model.Genre;

import java.util.UUID;

public record SeriesResponse(UUID id,
                             String name,
                             String cover,
                             String description,
                             Genre genre,
                             String director,
                             String year,
                             String episodes,
                             String seasons) {
}
