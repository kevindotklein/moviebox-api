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

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUsersService {

    private final UserRepository userRepository;
    private final ProfileMapper profileMapper;

    public List<ProfileResponse> execute(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        if (!user.getRole().equals(UserRole.ADMIN)) {
            throw new ForbiddenAccessException("User: "+email+" does not have permission to access this content");
        }

        List<User> users = userRepository.findAll();
        return profileMapper.to(users);
    }
}
