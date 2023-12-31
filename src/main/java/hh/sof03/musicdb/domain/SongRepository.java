package hh.sof03.musicdb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SongRepository extends CrudRepository<Song, Long> {

    List<Song> findByAlbumId(Long id);

    List<Song> findByNameLikeIgnoreCase(String name);
}
