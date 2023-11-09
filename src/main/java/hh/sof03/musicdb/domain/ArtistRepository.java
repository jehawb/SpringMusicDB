package hh.sof03.musicdb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArtistRepository extends CrudRepository<Artist, Long> {

    List<Artist> findByNameLikeIgnoreCase(String name);
}
