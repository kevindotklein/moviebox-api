package app.moviebox.user.controller;

import app.moviebox.rating.dto.AdminRatingsResponse;
import app.moviebox.user.service.GetAllRatingsService;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/all/ratings")
@RequiredArgsConstructor
@Tag(name = "admin")
public class AllRatingsController {

    private final GetAllRatingsService getAllRatingsService;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping
    public ResponseEntity<List<AdminRatingsResponse>> getAll(Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(getAllRatingsService.execute(principal.getUsername()), HttpStatus.OK);
    }

}
