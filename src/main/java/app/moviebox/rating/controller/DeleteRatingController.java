package app.moviebox.rating.controller;

import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.service.DeleteRatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "admin")
public class DeleteRatingController {

    private final DeleteRatingService deleteRatingService;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/movies/{movieId}/ratings/{ratingId}")
    public ResponseEntity<RatingResponse> deleteMovieRating(@PathVariable UUID movieId,
                                                            @PathVariable UUID ratingId,
                                                            Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(deleteRatingService.executeMovie(movieId, ratingId, principal.getUsername())
                , HttpStatus.OK);
    }

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/series/{seriesId}/ratings/{ratingId}")
    public ResponseEntity<RatingResponse> deleteSeriesRating(@PathVariable UUID seriesId,
                                                            @PathVariable UUID ratingId,
                                                            Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(deleteRatingService.executeSeries(seriesId, ratingId, principal.getUsername())
                , HttpStatus.OK);
    }
}
