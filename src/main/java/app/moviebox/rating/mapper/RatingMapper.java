package app.moviebox.rating.mapper;

import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.model.Rating;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class RatingMapper {

    public List<RatingResponse> to(List<Rating> ratings, UUID userId) {
        List<RatingResponse> response = new ArrayList<>();
        for(Rating r : ratings) {
            response.add(new RatingResponse(
                    r.getId(),
                    r.getComment(),
                    r.getStars(),
                    r.getCreatedAt(),
                    userId
            ));
        }
        return response;
    }

    public RatingResponse to(Rating rating, UUID userId) {
        return new RatingResponse(
                rating.getId(),
                rating.getComment(),
                rating.getStars(),
                rating.getCreatedAt(),
                userId
        );
    }

}
