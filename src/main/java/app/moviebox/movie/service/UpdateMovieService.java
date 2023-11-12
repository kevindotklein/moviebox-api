package app.moviebox.movie.service;

import app.moviebox.common.exception.ForbiddenAccessException;
import app.moviebox.common.exception.MovieNotFoundException;
import app.moviebox.common.exception.UserNotFoundException;
import app.moviebox.media.model.Genre;
import app.moviebox.movie.dto.MovieRequest;
import app.moviebox.movie.dto.MovieResponse;
import app.moviebox.movie.mapper.MovieMapper;
import app.moviebox.movie.model.Movie;
import app.moviebox.movie.repository.MovieRepository;
import app.moviebox.user.model.User;
import app.moviebox.user.model.UserRole;
import app.moviebox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateMovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final UserRepository userRepository;

    public MovieResponse execute(UUID movieId, MovieRequest request, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        if (!user.getRole().equals(UserRole.ADMIN)) {
            throw new ForbiddenAccessException("User: "+email+" does not have permission to access this content");
        }

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie: "+movieId+" not found"));

        movie.setName(request.name());
        movie.setCover(request.cover());
        movie.setDescription(request.description());
        movie.setGenre(request.genre());
        movie.setDirector(request.director());
        movie.setYear(request.year());
        movie.setDuration(request.duration());

        return movieMapper.to(movieRepository.save(movie));
    }

}
