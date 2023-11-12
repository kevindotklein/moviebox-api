package app.moviebox.user.mapper;

import app.moviebox.user.dto.ProfileResponse;
import app.moviebox.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileResponse to(User user);
}
