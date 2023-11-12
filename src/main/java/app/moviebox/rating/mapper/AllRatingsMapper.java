package app.moviebox.rating.mapper;

import app.moviebox.rating.dto.AllRatingsResponse;
import app.moviebox.rating.model.Rating;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllRatingsMapper {

    public List<AllRatingsResponse> to(List<Rating> ratings) {
        List<AllRatingsResponse> response = new ArrayList<>();
        for (Rating r : ratings) {
            response.add(
                    new AllRatingsResponse(
                            r.getId(),
                            r.getComment(),
                            r.getStars(),
                            r.getCreatedAt(),
                            r.getUser().getEmail(),
                            r.getUser().getId(),
                            r.getMedia().getId(),
                            r.getMedia().getName()
                    ));
        }
        return response;
    }
}
