package app.moviebox.user.service;

import app.moviebox.common.exception.ForbiddenAccessException;
import app.moviebox.common.exception.UserNotFoundException;
import app.moviebox.user.dto.ProfileResponse;
import app.moviebox.user.dto.UpdateUserRequest;
import app.moviebox.user.mapper.ProfileMapper;
import app.moviebox.user.model.User;
import app.moviebox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateUserService {

    private final UserRepository userRepository;
    private final ProfileMapper profileMapper;

    public ProfileResponse execute(UpdateUserRequest request, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        user.setFullName(request.fullName());
        user.setEmail(request.email());
        user.setBirthDate(request.birthDate());

        return profileMapper.to(userRepository.save(user));
    }
}
