package app.moviebox.rating.controller;

import app.moviebox.rating.dto.RatingRequest;
import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.service.CreateRatingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CreateRatingController {

    private final CreateRatingService createRatingService;

    @PostMapping("/movies/{movieId}/ratings")
    public ResponseEntity<RatingResponse> createMovieRating(@PathVariable UUID movieId,
                                                            @RequestBody @Valid RatingRequest request,
                                                            Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(createRatingService.executeMovies(movieId, request, principal.getUsername()),
                HttpStatus.CREATED);
    }

    @PostMapping("/series/{seriesId}/ratings")
    public ResponseEntity<RatingResponse> createSeriesRating(@PathVariable UUID seriesId,
                                                             @RequestBody @Valid RatingRequest request,
                                                             Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(createRatingService.executeSeries(seriesId, request, principal.getUsername()),
                HttpStatus.CREATED);
    }
}
