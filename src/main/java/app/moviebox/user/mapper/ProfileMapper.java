package app.moviebox.user.mapper;

import app.moviebox.user.dto.ProfileResponse;
import app.moviebox.user.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileResponse to(User user);
    List<ProfileResponse> to(List<User> users);
}
