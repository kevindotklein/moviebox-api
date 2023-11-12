package app.moviebox.rating.dto;

import java.util.List;
import java.util.UUID;

public record AdminRatingsResponse(UUID userId,
                                   String user,
                                   List<UserMovieRatingResponse> movies,
                                   List<UserSeriesRatingResponse> series) {
}
