package app.moviebox.rating.mapper;

import app.moviebox.rating.dto.UserRatingResponse;
import app.moviebox.rating.model.Rating;
import app.moviebox.user.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRatingMapper {

    public List<UserRatingResponse> to(List<Rating> ratings, User user) {
        List<UserRatingResponse> response = new ArrayList<>();
        if (user != null) {
            for (Rating r : ratings) {
                response.add(new UserRatingResponse(
                        r.getId(),
                        r.getComment(),
                        r.getStars(),
                        r.getCreatedAt(),
                        user.getFullName(),
                        user.getId(),
                        r.getMedia().getName()
                ));
            }
        }
        return response;
    }

    public UserRatingResponse to(Rating rating, User user) {
        return new UserRatingResponse(
                rating.getId(),
                rating.getComment(),
                rating.getStars(),
                rating.getCreatedAt(),
                user.getFullName(),
                user.getId(),
                rating.getMedia().getName()
        );
    }

}
