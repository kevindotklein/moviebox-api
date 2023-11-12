package app.moviebox.user.controller;

import app.moviebox.rating.dto.UserRatingResponse;
import app.moviebox.user.service.GetUserRatingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/ratings")
@RequiredArgsConstructor
public class GetUserRatingsController {

    private final GetUserRatingsService getUserRatingsService;

    @GetMapping
    public ResponseEntity<List<UserRatingResponse>> get(Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(getUserRatingsService.execute(principal.getUsername()), HttpStatus.OK);
    }
}
