package app.moviebox.user.controller;

import app.moviebox.user.dto.LoginRequest;
import app.moviebox.user.dto.LoginResponse;
import app.moviebox.user.dto.RegisterRequest;
import app.moviebox.user.dto.RegisterResponse;
import app.moviebox.user.service.LoginService;
import app.moviebox.user.service.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;
    private final RegisterService registerService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        return new ResponseEntity<>(loginService.execute(request), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request) {
        return new ResponseEntity<>(registerService.execute(request), HttpStatus.CREATED);
    }
}
