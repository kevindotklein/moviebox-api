package app.moviebox.rating.controller;

import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.service.GetRatingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GetRatingsController {

    private final GetRatingsService getRatingsService;

    @GetMapping("/movies/{movieId}/ratings")
    public ResponseEntity<List<RatingResponse>> getMovieRatings(@PathVariable UUID movieId) {
        return new ResponseEntity<>(getRatingsService.executeMovies(movieId), HttpStatus.OK);
    }

    @GetMapping("/series/{seriesId}/ratings")
    public ResponseEntity<List<RatingResponse>> getSeriesRatings(@PathVariable UUID seriesId) {
        return new ResponseEntity<>(getRatingsService.executeSeries(seriesId), HttpStatus.OK);
    }

}
