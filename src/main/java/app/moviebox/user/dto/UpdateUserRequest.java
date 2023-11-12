package app.moviebox.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record UpdateUserRequest(@NotBlank String fullName,
                                @NotBlank String email,
                                @NotNull Date birthDate) {
}
