package app.moviebox.rating.dto;

import app.moviebox.media.model.MediaType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.util.UUID;

public record UserRatingResponse(UUID id,
                                 String comment,
                                 String stars,
                                 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
                                 Instant createdAt,
                                 String user,
                                 UUID userId,
                                 MediaType mediaType,
                                 String media,
                                 UUID mediaId) {
}
