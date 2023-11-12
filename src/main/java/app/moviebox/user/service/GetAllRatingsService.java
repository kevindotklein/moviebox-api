package app.moviebox.user.service;

import app.moviebox.common.exception.ForbiddenAccessException;
import app.moviebox.common.exception.UserNotFoundException;
import app.moviebox.rating.dto.AllRatingsResponse;
import app.moviebox.rating.mapper.AllRatingsMapper;
import app.moviebox.rating.model.Rating;
import app.moviebox.rating.repository.RatingRepository;
import app.moviebox.user.model.User;
import app.moviebox.user.model.UserRole;
import app.moviebox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllRatingsService {

    private final RatingRepository ratingRepository;
    private final AllRatingsMapper allRatingsMapper;
    private final UserRepository userRepository;

    public List<AllRatingsResponse> execute(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        if (!user.getRole().equals(UserRole.ADMIN)) {
            throw new ForbiddenAccessException("User: "+email+" does not have permission to access this content");
        }

        List<Rating> ratings = ratingRepository.findAll();
        return allRatingsMapper.to(ratings);
    }
}
