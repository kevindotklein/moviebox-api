package app.moviebox.rating.dto;

import jakarta.validation.constraints.NotBlank;

public record RatingRequest(@NotBlank String comment,
                            @NotBlank String stars) {
}
