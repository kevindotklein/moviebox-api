package app.moviebox.rating.dto;

import java.util.UUID;

public record RatingResponse(UUID id,
                             String comment,
                             String stars) {
}
