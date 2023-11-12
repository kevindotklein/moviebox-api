package app.moviebox.rating.dto;

import java.time.Instant;
import java.util.UUID;

public record UserRatingResponse(UUID id,
                                 String comment,
                                 String stars,
                                 Instant createdAt,
                                 String user,
                                 UUID userId,
                                 String media) {
}