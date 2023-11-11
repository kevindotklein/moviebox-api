package app.moviebox.media.repository;

import app.moviebox.media.model.Genre;
import app.moviebox.media.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MediaRepository extends JpaRepository<Media, UUID> {
    List<Media> findAllByGenre(Genre genre);
}
