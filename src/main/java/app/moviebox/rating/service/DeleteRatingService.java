package app.moviebox.rating.service;

import app.moviebox.common.exception.*;
import app.moviebox.movie.model.Movie;
import app.moviebox.movie.repository.MovieRepository;
import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.mapper.RatingMapper;
import app.moviebox.rating.model.Rating;
import app.moviebox.rating.repository.RatingRepository;
import app.moviebox.user.model.User;
import app.moviebox.user.model.UserRole;
import app.moviebox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteRatingService {

    private final UserRepository userRepository;
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;
    private final MovieRepository movieRepository;

    public RatingResponse executeMovie(UUID movieId, UUID ratingId, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie: "+movieId+" not found"));

        Rating rating = ratingRepository.findById(ratingId)
                .orElseThrow(() -> new RatingNotFoundException("Rating: "+ratingId+" not found"));

        if (!rating.getMedia().getId().equals(movieId)) {
            throw new BadRequestException("Rating: "+ratingId+" does not belongs to Movie: "+movieId);
        }

        if (!user.getRole().equals(UserRole.ADMIN) && !user.getId().equals(rating.getUser().getId())) {
            throw new ForbiddenAccessException("User: "+email+" does not have permission to access this content");
        }

        ratingRepository.delete(rating);

        return ratingMapper.to(rating, rating.getUser());
    }
}
