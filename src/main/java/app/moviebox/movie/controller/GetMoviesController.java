package app.moviebox.movie.controller;

import app.moviebox.movie.dto.MovieResponse;
import app.moviebox.movie.service.GetMoviesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
@Tag(name = "movies")
public class GetMoviesController {

    private final GetMoviesService getMoviesService;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping
    public ResponseEntity<List<MovieResponse>> get(@RequestParam(name = "genre", required = false) String genre) {
        return new ResponseEntity<>(getMoviesService.execute(genre), HttpStatus.OK);
    }
}
