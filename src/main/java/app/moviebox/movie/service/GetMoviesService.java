package app.moviebox.movie.service;

import app.moviebox.common.exception.MovieNotFoundException;
import app.moviebox.media.model.Genre;
import app.moviebox.media.model.Media;
import app.moviebox.media.repository.MediaRepository;
import app.moviebox.movie.dto.MovieResponse;
import app.moviebox.movie.mapper.MovieMapper;
import app.moviebox.movie.model.Movie;
import app.moviebox.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetMoviesService {

    private final MediaRepository mediaRepository;
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public List<MovieResponse> execute(String genre) {
        List<MovieResponse> response = new ArrayList<>();

        for (Movie movie : movieRepository.findAll()) {
            Media media = mediaRepository.findById(movie.getId())
                    .orElseThrow(() -> new MovieNotFoundException("Movie: "+movie.getId()+" not found"));
            response.add(movieMapper.to(media, movie));
        }
        if (genre == null) return response;
        return response.stream().filter(m -> m.genre().equals(Genre.valueOf(genre))).collect(Collectors.toList());

    }

}
