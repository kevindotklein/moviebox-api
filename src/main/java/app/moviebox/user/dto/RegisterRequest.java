package app.moviebox.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record RegisterRequest(@NotBlank String fullName,
                              @NotBlank String email,
                              @NotBlank String password,
                              @NotNull Date birthDate) {
}
