package app.moviebox.movie.controller;

import app.moviebox.movie.dto.MovieResponse;
import app.moviebox.movie.service.DeleteMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class DeleteMovieController {

    private final DeleteMovieService deleteMovieService;

    @DeleteMapping("/{movieId}")
    public ResponseEntity<MovieResponse> deleteMovie(@PathVariable UUID movieId,
                                                     Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(deleteMovieService.execute(movieId, principal.getUsername()), HttpStatus.OK);
    }

}
