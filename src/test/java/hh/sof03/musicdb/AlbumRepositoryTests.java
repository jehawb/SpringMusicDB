package hh.sof03.musicdb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.musicdb.domain.Album;
import hh.sof03.musicdb.domain.AlbumRepository;

@DataJpaTest
public class AlbumRepositoryTests {
    
    @Autowired
    private AlbumRepository albumRepository;

    @Test
    public void testSaveAlbum() {
        Album album = new Album("test album", 1970, null);
        albumRepository.save(album);

        assertThat(albumRepository.findById(album.getId())).isNotNull();
    }

    @Test
    public void testDeleteAlbum() {
        Album album = new Album("test album", 1970, null);
        albumRepository.save(album);

        albumRepository.deleteById(album.getId());
        Album deletedAlbum = albumRepository.findById(album.getId()).orElse(null);

        assertThat(deletedAlbum).isNull();
    }
}
