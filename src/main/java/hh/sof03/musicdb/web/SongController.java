package hh.sof03.musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.musicdb.domain.AlbumRepository;
import hh.sof03.musicdb.domain.ArtistRepository;
import hh.sof03.musicdb.domain.SongRepository;

@CrossOrigin
@Controller
public class SongController {

    // Repositories

    @Autowired
    private SongRepository songRepo;

    // @Autowired
    // private AlbumRepository albumRepo;

    // @Autowired
    // private ArtistRepository artistRepo;

    // Endpoint handling

    @RequestMapping(value = "/songlist", method = RequestMethod.GET)
    public String songlist(Model model) {
        model.addAttribute("songs", songRepo.findAll());
        return "songlist"; // songlist.html
    }
    
}
