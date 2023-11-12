package app.moviebox.user.controller;

import app.moviebox.rating.dto.UserRatingsResponse;
import app.moviebox.user.service.GetUserRatingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/ratings")
@RequiredArgsConstructor
@Tag(name = "user")
public class GetUserRatingsController {

    private final GetUserRatingsService getUserRatingsService;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping
    public ResponseEntity<UserRatingsResponse> get(Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(getUserRatingsService.execute(principal.getUsername()), HttpStatus.OK);
    }
}
