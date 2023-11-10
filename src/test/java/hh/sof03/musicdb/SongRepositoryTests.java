package hh.sof03.musicdb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.musicdb.domain.Song;
import hh.sof03.musicdb.domain.SongRepository;

@DataJpaTest
public class SongRepositoryTests {

    @Autowired
    private SongRepository songRepository;

    @Test
    public void testSaveSong() {
        Song song = new Song("test song", "0:00", null);
        songRepository.save(song);

        assertThat(songRepository.findById(song.getId())).isNotNull();
    }

    @Test
    public void testDeleteSong() {
        Song song = new Song("test song", "0:00", null);
        songRepository.save(song);

        songRepository.deleteById(song.getId());
        Song deletedSong = songRepository.findById(song.getId()).orElse(null);

        assertThat(deletedSong).isNull();
    }
}
