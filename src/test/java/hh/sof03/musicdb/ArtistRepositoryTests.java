package hh.sof03.musicdb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.musicdb.domain.Artist;
import hh.sof03.musicdb.domain.ArtistRepository;

@DataJpaTest
public class ArtistRepositoryTests {
    
    @Autowired
    private ArtistRepository artistRepository;

    @Test
    public void testSaveArtist() {
        Artist artist = new Artist("test artist");
        artistRepository.save(artist);

        assertThat(artistRepository.findById(artist.getId())).isNotNull();
    }

    @Test
    public void testDeleteArtist() {
        Artist artist = new Artist("test artist");
        artistRepository.save(artist);

        artistRepository.deleteById(artist.getId());
        Artist deletedArtist = artistRepository.findById(artist.getId()).orElse(null);

        assertThat(deletedArtist).isNull();
    }
}
