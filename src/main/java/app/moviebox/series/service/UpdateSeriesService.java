package app.moviebox.series.service;

import app.moviebox.common.exception.ForbiddenAccessException;
import app.moviebox.common.exception.SeriesNotFoundException;
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

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateSeriesService {

    private final SeriesRepository seriesRepository;
    private final SeriesMapper seriesMapper;
    private final UserRepository userRepository;

    public SeriesResponse execute(UUID seriesId, SeriesRequest request, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User: "+email+" not found"));

        if (!user.getRole().equals(UserRole.ADMIN)) {
            throw new ForbiddenAccessException("User: "+email+" does not have permission to access this content");
        }

        Series series = seriesRepository.findById(seriesId)
                .orElseThrow(() -> new SeriesNotFoundException("Series: "+seriesId+" not found"));

        series.setName(request.name());
        series.setCover(request.cover());
        series.setDescription(request.description());
        series.setGenre(request.genre());
        series.setDirector(request.director());
        series.setYear(request.year());
        series.setEpisodes(request.episodes());
        series.setSeasons(request.seasons());

        return seriesMapper.to(seriesRepository.save(series));
    }
}
