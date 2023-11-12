package app.moviebox.rating.mapper;

import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.model.Rating;
import app.moviebox.user.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class RatingMapper {

    public List<RatingResponse> to(List<Rating> ratings, User user) {
        List<RatingResponse> response = new ArrayList<>();
        if (user != null) {
            for (Rating r : ratings) {
                response.add(new RatingResponse(
                        r.getId(),
                        r.getComment(),
                        r.getStars(),
                        r.getCreatedAt(),
                        user.getFullName(),
                        user.getId()
                ));
            }
        }
        return response;
    }

    public RatingResponse to(Rating rating, User user) {
        return new RatingResponse(
                rating.getId(),
                rating.getComment(),
                rating.getStars(),
                rating.getCreatedAt(),
                user.getFullName(),
                user.getId()
        );
    }

}
