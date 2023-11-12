package app.moviebox.user.service;

import app.moviebox.common.exception.UserNotFoundException;
import app.moviebox.user.dto.ProfileResponse;
import app.moviebox.user.mapper.ProfileMapper;
import app.moviebox.user.model.User;
import app.moviebox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProfileService {

    private final UserRepository userRepository;
    private final ProfileMapper profileMapper;

    public ProfileResponse execute(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: " + email + " not found"));
        return profileMapper.to(user);
    }
}
