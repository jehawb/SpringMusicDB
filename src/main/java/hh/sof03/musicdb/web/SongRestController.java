package hh.sof03.musicdb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.sof03.musicdb.domain.Song;
import hh.sof03.musicdb.domain.SongRepository;

@CrossOrigin
@RestController
public class SongRestController {
    
    @Autowired
    SongRepository songRepo;

    @RequestMapping(value = "/rest/songs", method = RequestMethod.GET)
    public @ResponseBody List<Song> songListRest() {
        return (List<Song>) songRepo.findAll();
    }
}
