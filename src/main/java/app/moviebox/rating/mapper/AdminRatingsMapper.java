package app.moviebox.rating.mapper;

import app.moviebox.rating.dto.AdminRatingsResponse;
import app.moviebox.rating.dto.UserMovieRatingResponse;
import app.moviebox.rating.dto.UserSeriesRatingResponse;
import app.moviebox.user.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminRatingsMapper {
    public AdminRatingsResponse to(User user,
                                  List<UserMovieRatingResponse> movies,
                                  List<UserSeriesRatingResponse> series) {
        return new AdminRatingsResponse(
                user.getId(),
                user.getFullName(),
                movies,
                series
        );
    }
}
