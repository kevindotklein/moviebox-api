package app.moviebox.user.dto;

import app.moviebox.user.model.UserRole;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public record ProfileResponse(UUID id,
                              String fullName,
                              String email,
                              Date birthDate,
                              Instant createdAt,
                              UserRole role) {
}
