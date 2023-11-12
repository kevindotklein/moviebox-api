package app.moviebox.user.dto;

import app.moviebox.user.model.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.ExampleObject;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import static org.hibernate.type.descriptor.java.JdbcDateJavaType.DATE_FORMAT;

public record ProfileResponse(UUID id,
                              String fullName,
                              String email,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                              Date birthDate,
                              @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
                              Instant createdAt,
                              UserRole role) {
}
