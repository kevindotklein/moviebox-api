package app.moviebox.movie.controller;

import app.moviebox.movie.dto.MovieRequest;
import app.moviebox.movie.dto.MovieResponse;
import app.moviebox.movie.service.CreateMovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class CreateMovieController {

    private final CreateMovieService createMovieService;

    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@RequestBody @Valid MovieRequest request,
                                                    Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(createMovieService.execute(request, principal.getUsername()), HttpStatus.CREATED);
    }

}
