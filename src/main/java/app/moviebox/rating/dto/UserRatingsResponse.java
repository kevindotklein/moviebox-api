package app.moviebox.rating.dto;

import java.util.List;

public record UserRatingsResponse(List<UserMovieRatingResponse> movies,
                                  List<UserSeriesRatingResponse> series) {
}
