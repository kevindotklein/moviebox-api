package app.moviebox.movie.controller;

import app.moviebox.movie.dto.MovieRequest;
import app.moviebox.movie.dto.MovieResponse;
import app.moviebox.movie.service.UpdateMovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class UpdateMovieController {

    private final UpdateMovieService updateMovieService;

    @PutMapping("/{movieId}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable UUID movieId,
                                                     @RequestBody @Valid MovieRequest request,
                                                     Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(updateMovieService.execute(movieId, request, principal.getUsername())
                , HttpStatus.OK);
    }

}
