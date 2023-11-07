package hh.sof03.musicdb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.sof03.musicdb.domain.Artist;
import hh.sof03.musicdb.domain.ArtistRepository;

@CrossOrigin
@RestController
public class ArtistRestController {
    
    @Autowired
    ArtistRepository artistRepo;

    @RequestMapping(value = "/rest/artists", method = RequestMethod.GET)
    public @ResponseBody List<Artist> artistListRest() {
        return (List<Artist>) artistRepo.findAll();
    }
}
