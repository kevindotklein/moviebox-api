package app.moviebox.user.service;

import app.moviebox.common.exception.AlreadyRegisteredException;
import app.moviebox.user.dto.RegisterRequest;
import app.moviebox.user.dto.RegisterResponse;
import app.moviebox.user.mapper.RegisterMapper;
import app.moviebox.user.model.User;
import app.moviebox.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegisterMapper registerMapper;

    public RegisterResponse execute(RegisterRequest request) {
        if(userRepository.existsByEmail(request.email())) {
            throw new AlreadyRegisteredException("Email: " + request.email() + " already registered");
        }

        User user = new User(request.fullName(), request.email(),
                passwordEncoder.encode(request.password()), request.birthDate());

        userRepository.save(user);

        return registerMapper.to(user);
    }
}
