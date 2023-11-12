package app.moviebox.user.controller;

import app.moviebox.user.dto.ProfileResponse;
import app.moviebox.user.service.GetAllUsersService;
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
@RequestMapping("/api/v1/all/users")
@RequiredArgsConstructor
public class GetAllUsersController {

    private final GetAllUsersService getAllUsersService;

    @GetMapping
    public ResponseEntity<List<ProfileResponse>> getAll(Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(getAllUsersService.execute(principal.getUsername()), HttpStatus.OK);
    }
}
