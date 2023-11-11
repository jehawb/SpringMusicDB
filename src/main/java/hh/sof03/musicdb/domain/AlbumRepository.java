package hh.sof03.musicdb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AlbumRepository extends CrudRepository<Album, Long> {
    
    List<Album> findByArtistId(Long id);

    // TODO: LIKE SQL queries are inefficient and should be replaced
    List<Album> findByNameLikeIgnoreCase(String name);

}
