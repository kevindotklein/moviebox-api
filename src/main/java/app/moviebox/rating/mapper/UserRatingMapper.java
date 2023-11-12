package app.moviebox.rating.mapper;

import app.moviebox.media.model.MediaType;
import app.moviebox.rating.dto.UserRatingResponse;
import app.moviebox.rating.model.Rating;
import app.moviebox.user.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRatingMapper {

    public List<UserRatingResponse> to(List<Rating> ratings, User user, MediaType mediaType) {
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
                        mediaType
                ));
            }
        }
        return response;
    }

    public UserRatingResponse to(Rating rating, User user, MediaType mediaType) {
        return new UserRatingResponse(
                rating.getId(),
                rating.getComment(),
                rating.getStars(),
                rating.getCreatedAt(),
                user.getFullName(),
                user.getId(),
                mediaType
        );
    }

}
