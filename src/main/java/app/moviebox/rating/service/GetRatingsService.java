package app.moviebox.rating.service;

import app.moviebox.common.exception.MovieNotFoundException;
import app.moviebox.movie.model.Movie;
import app.moviebox.movie.repository.MovieRepository;
import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.mapper.RatingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetRatingsService {

    private final RatingMapper ratingMapper;
    private final MovieRepository movieRepository;

    public List<RatingResponse> execute(UUID movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie: "+movieId+" not found"));
        return ratingMapper.to(movie.getRatings());
    }

}
