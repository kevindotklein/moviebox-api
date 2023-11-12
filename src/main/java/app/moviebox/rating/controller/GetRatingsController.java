package app.moviebox.rating.controller;

import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.service.GetRatingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "ratings")
public class GetRatingsController {

    private final GetRatingsService getRatingsService;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/movies/{movieId}/ratings")
    public ResponseEntity<List<RatingResponse>> getMovieRatings(@PathVariable UUID movieId,
                                                                Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(getRatingsService.executeMovies(movieId, principal.getUsername()), HttpStatus.OK);
    }

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/series/{seriesId}/ratings")
    public ResponseEntity<List<RatingResponse>> getSeriesRatings(@PathVariable UUID seriesId,
                                                                 Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(getRatingsService.executeSeries(seriesId, principal.getUsername()), HttpStatus.OK);
    }

}
