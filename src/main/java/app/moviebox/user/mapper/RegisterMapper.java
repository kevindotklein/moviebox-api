package app.moviebox.user.mapper;

import app.moviebox.user.dto.RegisterResponse;
import app.moviebox.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterMapper {
    RegisterResponse to(User user);
}
