package app.moviebox.rating.mapper;

import app.moviebox.movie.dto.MovieResponse;
import app.moviebox.rating.dto.UserMovieRatingResponse;
import app.moviebox.rating.dto.UserRatingsResponse;
import app.moviebox.rating.dto.UserSeriesRatingResponse;
import app.moviebox.rating.model.Rating;
import app.moviebox.series.dto.SeriesResponse;
import app.moviebox.user.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRatingMapper {

    public UserMovieRatingResponse to(Rating rating, User user, MovieResponse movie) {
        return new UserMovieRatingResponse(
                rating.getId(),
                rating.getComment(),
                rating.getStars(),
                rating.getCreatedAt(),
                user.getFullName(),
                user.getId(),
                movie
        );
    }

    public UserSeriesRatingResponse to(Rating rating, User user, SeriesResponse series) {
        return new UserSeriesRatingResponse(
                rating.getId(),
                rating.getComment(),
                rating.getStars(),
                rating.getCreatedAt(),
                user.getFullName(),
                user.getId(),
                series
        );
    }

    public UserRatingsResponse to(List<UserMovieRatingResponse> movies, List<UserSeriesRatingResponse> series) {
        return new UserRatingsResponse(
                movies,
                series
        );
    }

}
