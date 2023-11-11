package app.moviebox.user.controller;

import app.moviebox.user.dto.RegisterResponse;
import app.moviebox.user.service.GetProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class GetProfileController {

    private final GetProfileService getProfileService;

    @GetMapping
    public ResponseEntity<RegisterResponse> get(Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(getProfileService.execute(principal.getUsername()), HttpStatus.OK);
    }
}
