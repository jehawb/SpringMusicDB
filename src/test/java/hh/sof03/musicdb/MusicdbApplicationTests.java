package hh.sof03.musicdb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof03.musicdb.web.AlbumController;
import hh.sof03.musicdb.web.AlbumRestController;
import hh.sof03.musicdb.web.ArtistController;
import hh.sof03.musicdb.web.ArtistRestController;
import hh.sof03.musicdb.web.HomepageController;
import hh.sof03.musicdb.web.SearchController;
import hh.sof03.musicdb.web.SongController;
import hh.sof03.musicdb.web.SongRestController;

@SpringBootTest
class MusicdbApplicationTests {

    @Autowired
    private ArtistController artistController;

    @Autowired
    private AlbumController albumController;

    @Autowired
    private SongController songController;

    @Autowired
    private HomepageController homepageController;

    @Autowired
    private SearchController searchController;

    @Autowired
    private ArtistRestController artistRestController;

    @Autowired
    private AlbumRestController albumRestController;

    @Autowired
    private SongRestController songRestController;

    // Smoke testing

    @Test
    public void contextLoads() throws Exception {
        assertThat(artistController).isNotNull();
        assertThat(albumController).isNotNull();
        assertThat(songController).isNotNull();
        assertThat(homepageController).isNotNull();
        assertThat(searchController).isNotNull();
        assertThat(artistRestController).isNotNull();
        assertThat(albumRestController).isNotNull();
        assertThat(songRestController).isNotNull();
    }

}
