package app.moviebox.user.service;

import app.moviebox.auth.TokenService;
import app.moviebox.user.dto.LoginRequest;
import app.moviebox.user.dto.LoginResponse;
import app.moviebox.user.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private AuthenticationManager authManager;
    private TokenService tokenService;

    public LoginResponse execute(LoginRequest request) {

        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));

        return new LoginResponse(tokenService.generateToken((User) authentication.getPrincipal()));
    }
}
