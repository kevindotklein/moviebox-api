package app.moviebox.user.controller;

import app.moviebox.user.dto.ProfileResponse;
import app.moviebox.user.service.DeleteUserService;
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
public class DeleteUserController {

    private final DeleteUserService deleteUserService;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<ProfileResponse> deleteUser(@PathVariable UUID userId,
                                                      Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(deleteUserService.execute(userId, principal.getUsername()), HttpStatus.OK);
    }
}
