package app.moviebox.movie.mapper;

import app.moviebox.media.model.Media;
import app.moviebox.movie.dto.MovieResponse;
import app.moviebox.movie.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieResponse to(Media media, Movie movie) {
        return new MovieResponse(
                media.getId(),
                media.getName(),
                media.getCover(),
                media.getDescription(),
                media.getGenre(),
                media.getDirector(),
                media.getYear(),
                movie.getDuration());
    }
}
