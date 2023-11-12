package app.moviebox.user.service;

import app.moviebox.common.exception.ForbiddenAccessException;
import app.moviebox.common.exception.UserNotFoundException;
import app.moviebox.media.model.MediaType;
import app.moviebox.movie.model.Movie;
import app.moviebox.movie.repository.MovieRepository;
import app.moviebox.rating.dto.UserRatingResponse;
import app.moviebox.rating.mapper.UserRatingMapper;
import app.moviebox.rating.model.Rating;
import app.moviebox.series.model.Series;
import app.moviebox.series.repository.SeriesRepository;
import app.moviebox.user.model.User;
import app.moviebox.user.model.UserRole;
import app.moviebox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetAllRatingsService {

    private final UserRepository userRepository;
    private final SeriesRepository seriesRepository;
    private final MovieRepository movieRepository;
    private final UserRatingMapper userRatingMapper;

    public List<UserRatingResponse> execute(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        if (!user.getRole().equals(UserRole.ADMIN)) {
            throw new ForbiddenAccessException("User: "+email+" does not have permission to access this content");
        }

        List<UserRatingResponse> response = new ArrayList<>();
        for (User u : userRepository.findAll()) {

            for (Rating r : u.getRatings()) {
                Optional<Movie> movie = movieRepository.findById(r.getMedia().getId());
                movie.ifPresent(m -> response.add(userRatingMapper.to(r, u, MediaType.movie, m.getName(), m.getId())));
                Optional<Series> series = seriesRepository.findById(r.getMedia().getId());
                series.ifPresent(s -> response.add(userRatingMapper.to(r, u, MediaType.series, s.getName(), s.getId())));
            }

        }
        return  response;
    }
}
