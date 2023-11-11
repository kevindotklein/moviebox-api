package app.moviebox.series.service;

import app.moviebox.common.exception.ForbiddenAccessException;
import app.moviebox.common.exception.UserNotFoundException;
import app.moviebox.series.dto.SeriesRequest;
import app.moviebox.series.dto.SeriesResponse;
import app.moviebox.series.mapper.SeriesMapper;
import app.moviebox.series.model.Series;
import app.moviebox.series.repository.SeriesRepository;
import app.moviebox.user.model.User;
import app.moviebox.user.model.UserRole;
import app.moviebox.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSeriesService {

    private final SeriesRepository seriesRepository;
    private final UserRepository userRepository;
    private final SeriesMapper seriesMapper;

    public SeriesResponse execute(SeriesRequest request, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        if (!user.getRole().equals(UserRole.ADMIN)) {
            throw new ForbiddenAccessException("User: "+email+" does not have permission to access this content");
        }

        Series series = new Series(
                request.name(),
                request.cover(),
                request.description(),
                request.genre(),
                request.director(),
                request.year(),
                request.episodes(),
                request.seasons()
        );

        return seriesMapper.to(seriesRepository.save(series));
    }

}
