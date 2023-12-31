package app.moviebox.rating.service;

import app.moviebox.common.exception.MovieNotFoundException;
import app.moviebox.common.exception.SeriesNotFoundException;
import app.moviebox.common.exception.UserNotFoundException;
import app.moviebox.movie.model.Movie;
import app.moviebox.movie.repository.MovieRepository;
import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.mapper.RatingMapper;
import app.moviebox.rating.model.Rating;
import app.moviebox.series.model.Series;
import app.moviebox.series.repository.SeriesRepository;
import app.moviebox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetRatingsService {

    private final RatingMapper ratingMapper;
    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;
    private final UserRepository userRepository;

    public List<RatingResponse> executeMovies(UUID movieId, String email) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie: "+movieId+" not found"));

        userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));


        List<RatingResponse> ratings = new ArrayList<>();
        for (Rating r : movie.getRatings()) {
            ratings.add(ratingMapper.to(r, userRepository.findById(r.getUser().getId()).orElseThrow(
                    () -> new UserNotFoundException("User: "+r.getUser().getId().toString()+" not found")))
            );
        }
        return ratings;

    }

    public List<RatingResponse> executeSeries(UUID seriesId, String email) {
        Series series = seriesRepository.findById(seriesId)
                .orElseThrow(() -> new SeriesNotFoundException("Series: "+seriesId+" not found"));

        userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        List<RatingResponse> ratings = new ArrayList<>();
        for (Rating r : series.getRatings()) {
            ratings.add(ratingMapper.to(r, userRepository.findById(r.getUser().getId()).orElseThrow(
                    () -> new UserNotFoundException("User: "+r.getUser().getId().toString()+" not found")))
            );
        }
        return ratings;
    }

}
