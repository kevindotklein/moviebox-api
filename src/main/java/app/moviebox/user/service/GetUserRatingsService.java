package app.moviebox.user.service;

import app.moviebox.common.exception.UserNotFoundException;
import app.moviebox.movie.mapper.MovieMapper;
import app.moviebox.movie.model.Movie;
import app.moviebox.movie.repository.MovieRepository;
import app.moviebox.rating.dto.UserMovieRatingResponse;
import app.moviebox.rating.dto.UserRatingsResponse;
import app.moviebox.rating.dto.UserSeriesRatingResponse;
import app.moviebox.rating.mapper.UserRatingMapper;
import app.moviebox.rating.model.Rating;
import app.moviebox.series.mapper.SeriesMapper;
import app.moviebox.series.model.Series;
import app.moviebox.series.repository.SeriesRepository;
import app.moviebox.user.model.User;
import app.moviebox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetUserRatingsService {

    private final UserRepository userRepository;
    private final UserRatingMapper userRatingMapper;
    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;
    private final MovieMapper movieMapper;
    private final SeriesMapper seriesMapper;

    public UserRatingsResponse execute(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        List<UserMovieRatingResponse> movieResponse = new ArrayList<>();
        List<UserSeriesRatingResponse> seriesResponse = new ArrayList<>();

        for (Rating r : user.getRatings()) {
            Optional<Movie> movie = movieRepository.findById(r.getMedia().getId());
            movie.ifPresent(value -> movieResponse.add(userRatingMapper.to(r, user, movieMapper.to(value))));
            Optional<Series> series = seriesRepository.findById(r.getMedia().getId());
            series.ifPresent(value -> seriesResponse.add(userRatingMapper.to(r, user, seriesMapper.to(value))));
        }

        return userRatingMapper.to(movieResponse, seriesResponse);
    }
}
