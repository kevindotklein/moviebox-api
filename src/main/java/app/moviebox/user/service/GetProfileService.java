package app.moviebox.user.service;

import app.moviebox.common.exception.UserNotFoundException;
import app.moviebox.user.dto.RegisterResponse;
import app.moviebox.user.mapper.RegisterMapper;
import app.moviebox.user.model.User;
import app.moviebox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProfileService {

    private final UserRepository userRepository;
    private final RegisterMapper registerMapper;

    public RegisterResponse execute(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: " + email + " not found"));
        return registerMapper.to(user);
    }
}
