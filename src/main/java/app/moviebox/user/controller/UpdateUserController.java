package app.moviebox.user.controller;

import app.moviebox.user.dto.ProfileResponse;
import app.moviebox.user.dto.UpdateProfileRequest;
import app.moviebox.user.service.UpdateUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "user")
public class UpdateUserController {

    private final UpdateUserService updateUserService;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @PutMapping("/users/{userId}")
    public ResponseEntity<ProfileResponse> updateUser(@PathVariable UUID userId,
                                                      @RequestBody @Valid UpdateProfileRequest request,
                                                      Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(updateUserService.execute(userId, request, principal.getUsername()), HttpStatus.OK);
    }

}
