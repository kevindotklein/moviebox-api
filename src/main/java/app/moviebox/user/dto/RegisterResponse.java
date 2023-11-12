package app.moviebox.user.dto;

import app.moviebox.user.model.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public record RegisterResponse(UUID id,
                               String fullName,
                               String email,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                               Date birthDate,
                               @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
                               Instant createdAt,
                               UserRole role,
                               String accessToken) {
}
