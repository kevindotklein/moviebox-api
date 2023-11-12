package app.moviebox.user.service;

import app.moviebox.common.exception.ForbiddenAccessException;
import app.moviebox.common.exception.UserNotFoundException;
import app.moviebox.user.dto.ProfileResponse;
import app.moviebox.user.mapper.ProfileMapper;
import app.moviebox.user.model.User;
import app.moviebox.user.model.UserRole;
import app.moviebox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteUserService {

    private final UserRepository userRepository;
    private final ProfileMapper profileMapper;

    public ProfileResponse execute(UUID userId, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        User deletedUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User: "+userId+" not found"));

        if (!user.getRole().equals(UserRole.ADMIN) && !user.getId().equals(userId)) {
            throw new ForbiddenAccessException("User: "+email+" does not have permission to access this content");
        }

        userRepository.delete(deletedUser);
        return profileMapper.to(deletedUser);

    }
}
