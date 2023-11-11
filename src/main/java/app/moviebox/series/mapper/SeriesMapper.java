package app.moviebox.series.mapper;

import app.moviebox.media.model.Media;
import app.moviebox.series.dto.SeriesResponse;
import app.moviebox.series.model.Series;
import org.springframework.stereotype.Component;

@Component
public class SeriesMapper {

    public SeriesResponse to(Media media, Series series) {
        return new SeriesResponse(
                media.getId(),
                media.getName(),
                media.getCover(),
                media.getDescription(),
                media.getGenre(),
                media.getDirector(),
                media.getYear(),
                series.getEpisodes(),
                series.getSeasons());
    }

    public SeriesResponse to(Series series) {
        return new SeriesResponse(
                series.getId(),
                series.getName(),
                series.getCover(),
                series.getDescription(),
                series.getGenre(),
                series.getDirector(),
                series.getYear(),
                series.getEpisodes(),
                series.getSeasons()

        );
    }
}
