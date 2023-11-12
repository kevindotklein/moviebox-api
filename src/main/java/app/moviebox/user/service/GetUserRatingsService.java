package app.moviebox.user.service;

import app.moviebox.common.exception.UserNotFoundException;
import app.moviebox.rating.dto.UserRatingResponse;
import app.moviebox.rating.mapper.UserRatingMapper;
import app.moviebox.user.model.User;
import app.moviebox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetUserRatingsService {

    private final UserRepository userRepository;
    private final UserRatingMapper userRatingMapper;

    public List<UserRatingResponse> execute(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        return userRatingMapper.to(user.getRatings(), user);
    }
}
