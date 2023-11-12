package app.moviebox.rating.controller;

import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.service.DeleteRatingService;
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
public class DeleteRatingController {

    private final DeleteRatingService deleteRatingService;

    @DeleteMapping("/movies/{movieId}/ratings/{ratingId}")
    public ResponseEntity<RatingResponse> deleteMovieRating(@PathVariable UUID movieId,
                                                            @PathVariable UUID ratingId,
                                                            Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(deleteRatingService.executeMovie(movieId, ratingId, principal.getUsername())
                , HttpStatus.OK);
    }
}
