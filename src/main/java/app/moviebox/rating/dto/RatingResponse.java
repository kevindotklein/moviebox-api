package app.moviebox.rating.dto;

import java.time.Instant;
import java.util.UUID;

public record RatingResponse(UUID id,
                             String comment,
                             String stars,
                             Instant createdAt,
                             UUID userId) {
}
