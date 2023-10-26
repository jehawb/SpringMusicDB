package hh.sof03.musicdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.musicdb.domain.Album;
import hh.sof03.musicdb.domain.AlbumRepository;
import hh.sof03.musicdb.domain.Artist;
import hh.sof03.musicdb.domain.ArtistRepository;
import hh.sof03.musicdb.domain.Song;
import hh.sof03.musicdb.domain.SongRepository;

@SpringBootApplication
public class MusicdbApplication {

    private static final Logger log = LoggerFactory.getLogger(MusicdbApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MusicdbApplication.class, args);
    }

    @Bean
    public CommandLineRunner musicdbDemo(ArtistRepository artistRepo, AlbumRepository albumRepo,
            SongRepository songRepo) {
        return (args) -> {

            log.info("Saving artists");

            Artist art1 = new Artist("Vesa-Matti Loiri");
            Artist art2 = new Artist("Basshunter");

            artistRepo.save(art1);
            artistRepo.save(art2);

            log.info("Fetch artists");

            for (Artist artist : artistRepo.findAll()) {
                log.info(artist.toString());
            }

            log.info("Saving albums");

            Album alb1 = new Album("Hyvää puuta", 2009, art1);
            Album alb2 = new Album("LOL", 2006, art2);

            albumRepo.save(alb1);
            albumRepo.save(alb2);

            log.info("Fetch albums");

            for (Album album : albumRepo.findAll()) {
                log.info(album.toString());
            }

            log.info("Saving songs");

            Song son1 = new Song("Hyvää puuta", "4:56", alb1);
            Song son2 = new Song("Boten Anna", "3:28", alb2);

            songRepo.save(son1);
            songRepo.save(son2);

            log.info("Fetch songs");

            for (Song song : songRepo.findAll()) {
                log.info(song.toString());
            }

        };
    }

}
