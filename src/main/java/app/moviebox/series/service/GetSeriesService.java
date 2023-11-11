package app.moviebox.series.service;

import app.moviebox.common.exception.SeriesNotFoundException;
import app.moviebox.media.model.Genre;
import app.moviebox.media.model.Media;
import app.moviebox.media.repository.MediaRepository;
import app.moviebox.series.dto.SeriesResponse;
import app.moviebox.series.mapper.SeriesMapper;
import app.moviebox.series.model.Series;
import app.moviebox.series.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetSeriesService {

    private final MediaRepository mediaRepository;
    private final SeriesRepository seriesRepository;
    private final SeriesMapper seriesMapper;

    public List<SeriesResponse> execute(String genre) {
        List<SeriesResponse> response = new ArrayList<>();

        for (Series series : seriesRepository.findAll()) {
            Media media = mediaRepository.findById(series.getId())
                    .orElseThrow(() -> new SeriesNotFoundException("Series: "+series.getId()+" not found"));
            response.add(seriesMapper.to(media, series));
        }
        if (genre == null) return response;
        return response.stream().filter(m -> m.genre().equals(Genre.valueOf(genre))).collect(Collectors.toList());
    }

}
