package app.moviebox.rating.service;

import app.moviebox.common.exception.MovieNotFoundException;
import app.moviebox.common.exception.SeriesNotFoundException;
import app.moviebox.media.model.Media;
import app.moviebox.media.repository.MediaRepository;
import app.moviebox.movie.model.Movie;
import app.moviebox.movie.repository.MovieRepository;
import app.moviebox.rating.dto.RatingRequest;
import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.mapper.RatingMapper;
import app.moviebox.rating.model.Rating;
import app.moviebox.rating.repository.RatingRepository;
import app.moviebox.series.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateRatingService {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;
    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;
    private final MediaRepository mediaRepository;

    public RatingResponse executeMovies(UUID movieId, RatingRequest request) {

        movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie: "+movieId+" not found"));

        Media media = mediaRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Media: "+movieId+" not found"));

        Rating rating = new Rating(
                request.comment(),
                request.stars(),
                media
        );

        return ratingMapper.to(ratingRepository.save(rating));
    }

    public RatingResponse executeSeries(UUID seriesId, RatingRequest request) {

        seriesRepository.findById(seriesId)
                .orElseThrow(() -> new SeriesNotFoundException("Series: "+seriesId+" not found"));

        Media media = mediaRepository.findById(seriesId)
                .orElseThrow(() -> new SeriesNotFoundException("Media: "+seriesId+" not found"));

        Rating rating = new Rating(
                request.comment(),
                request.stars(),
                media
        );

        return ratingMapper.to(ratingRepository.save(rating));
    }

}
