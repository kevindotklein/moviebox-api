package app.moviebox.rating.service;

import app.moviebox.common.exception.MovieNotFoundException;
import app.moviebox.common.exception.SeriesNotFoundException;
import app.moviebox.movie.model.Movie;
import app.moviebox.movie.repository.MovieRepository;
import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.mapper.RatingMapper;
import app.moviebox.series.model.Series;
import app.moviebox.series.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetRatingsService {

    private final RatingMapper ratingMapper;
    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;

    public List<RatingResponse> executeMovies(UUID movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie: "+movieId+" not found"));
        return ratingMapper.to(movie.getRatings());
    }

    public List<RatingResponse> executeSeries(UUID seriesId) {
        Series series = seriesRepository.findById(seriesId)
                .orElseThrow(() -> new SeriesNotFoundException("Series: "+seriesId+" not found"));
        return ratingMapper.to(series.getRatings());
    }

}
