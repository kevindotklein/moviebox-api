package app.moviebox.rating.mapper;

import app.moviebox.rating.dto.RatingResponse;
import app.moviebox.rating.model.Rating;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    RatingResponse to(Rating rating);
    List<RatingResponse> to(List<Rating> ratings);
}
