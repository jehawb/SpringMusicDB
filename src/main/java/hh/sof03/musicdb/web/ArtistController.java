package hh.sof03.musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.musicdb.domain.Album;
import hh.sof03.musicdb.domain.Artist;
import hh.sof03.musicdb.domain.ArtistRepository;

@CrossOrigin
@Controller
public class ArtistController {
    
    // Repositories

    @Autowired
    private ArtistRepository artistRepo;

    // Endpoint handling

    @RequestMapping(value = "/artistlist", method = RequestMethod.GET)
    public String artistlist(Model model) {
        model.addAttribute("artist", artistRepo.findAll());
        return "artistlist"; // artistlist.html
    }

    @RequestMapping(value = "/editartist/{id}", method = RequestMethod.GET)
    public String editalbum(@PathVariable("id") Long id, Model model) {
        model.addAttribute("artist", artistRepo.findById(id));
        return "editartist"; // editartist.html
    }

    @RequestMapping(value = "/saveartist", method = RequestMethod.POST)
    public String savealbum(Artist artist) {
        artistRepo.save(artist);
        return "redirect:/artistlist"; // artistlist.html
    }
}
