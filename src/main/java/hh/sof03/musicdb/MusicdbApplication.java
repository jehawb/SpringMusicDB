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

            // Test data

            log.info("Adding testing data");

            // Placeholder artist and album

            albumRepo.save(new Album(" --- ", 0, artistRepo.save(new Artist(" --- "))));

            // Loiri

            Artist loiri = artistRepo.save(new Artist("Vesa-Matti Loiri"));

            Album leinoalb = albumRepo.save(new Album("Eino Leino", 1978, loiri));

            songRepo.save(new Song("Höyhensaaret", "4:24", leinoalb));
            songRepo.save(new Song("Elegia", "3:56", leinoalb));
            songRepo.save(new Song("Tulkaa kotiin", "3:30", leinoalb));
            songRepo.save(new Song("Ja vuodet ne käy", "2:04", leinoalb));
            songRepo.save(new Song("Laulajan laulu", "2:42", leinoalb));
            songRepo.save(new Song("Nocturne", "3:31", leinoalb));
            songRepo.save(new Song("Väinämöisen laulu", "3:12", leinoalb));
            songRepo.save(new Song("Hautalaulu", "2:26", leinoalb));
            songRepo.save(new Song("Kun muistelen", "3:18", leinoalb));
            songRepo.save(new Song("Lapin kesä", "4:24", leinoalb));

            Album puutaalb = albumRepo.save(new Album("Hyvää puuta", 2009, loiri));

            songRepo.save(new Song("Miksi mä maailmalle laulaisin", "4:00", puutaalb));
            songRepo.save(new Song("Aapakarhu", "2:58", puutaalb));
            songRepo.save(new Song("Kaiken nähnyt", "4:08", puutaalb));
            songRepo.save(new Song("Missä kotini on", "4:10", puutaalb));
            songRepo.save(new Song("Hyvää puuta", "4:56", puutaalb));
            songRepo.save(new Song("Vilukukka", "3:44", puutaalb));
            songRepo.save(new Song("Taivun mutten murru", "4:27", puutaalb));
            songRepo.save(new Song("Ystäväni", "4:20", puutaalb));
            songRepo.save(new Song("Ei tullutkaan äänettömyys", "4:18", puutaalb));
            songRepo.save(new Song("Hyvää elämää", "2:59", puutaalb));
            songRepo.save(new Song("Sadan miehen leukaluut", "3:33", puutaalb));
            songRepo.save(new Song("Uskon", "3:11", puutaalb));

            // Basshunter

            Artist basshunter = artistRepo.save(new Artist("Basshunter"));

            Album lolalb = albumRepo.save(new Album("LOL <(^^,)>", 2006, basshunter));

            songRepo.save(new Song("Vi sitter i Ventrilo och spelar DotA [Radio advert]", "3:21", lolalb));
            songRepo.save(new Song("Boten Anna [Radio Edit]", "3:28", lolalb));
            songRepo.save(new Song("Strand Tylösand", "3:17", lolalb));
            songRepo.save(new Song("Sverige", "2:58", lolalb));
            songRepo.save(new Song("Hallå där", "2:38", lolalb));
            songRepo.save(new Song("Mellan oss två", "3:57", lolalb));
            songRepo.save(new Song("Var är jag", "4:00", lolalb));
            songRepo.save(new Song("Utan stjärnorna", "3:50", lolalb));
            songRepo.save(new Song("Festfolk [2006 Remix]", "4:00", lolalb));
            songRepo.save(new Song("Vifta med händerna [Basshunter Remix]", "3:10", lolalb));
            songRepo.save(new Song("Professional Party People", "3:09", lolalb));
            songRepo.save(new Song("I'm Your Basscreator", "5:24", lolalb));
            songRepo.save(new Song("Boten Anna [Instrumental]", "3:20", lolalb));
            songRepo.save(new Song("Vi sitter i Ventrilo och spelar DotA [Extended Version]", "7:45", lolalb));

        };
    }

}
