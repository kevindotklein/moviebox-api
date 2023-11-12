package app.moviebox.user.mapper;

import app.moviebox.auth.TokenService;
import app.moviebox.user.dto.RegisterResponse;
import app.moviebox.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterMapper {

    private final TokenService tokenService;

    public RegisterResponse to(User user) {
        return new RegisterResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getBirthDate(),
                user.getCreatedAt(),
                user.getRole(),
                tokenService.generateToken(user));
    }
}
