package app.moviebox.user.service;

import app.moviebox.common.exception.ForbiddenAccessException;
import app.moviebox.common.exception.UserNotFoundException;
import app.moviebox.user.dto.ProfileResponse;
import app.moviebox.user.dto.UpdateProfileRequest;
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

    public ProfileResponse execute(UUID userId, UpdateProfileRequest request, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        User updatedUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User: "+userId+" not found"));

        if (!user.getId().equals(userId)) {
            throw new ForbiddenAccessException("User: "+email+" does not have permission to access this content");
        }

        updatedUser.setFullName(request.fullName());
        updatedUser.setEmail(request.email());
        updatedUser.setBirthDate(request.birthDate());

        return profileMapper.to(userRepository.save(updatedUser));
    }
}
