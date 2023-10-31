package hh.sof03.musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.musicdb.domain.Artist;
import hh.sof03.musicdb.domain.ArtistRepository;

@CrossOrigin
@Controller
public class ArtistController {

    // Repositories

    @Autowired
    private ArtistRepository artistRepo;

    // Endpoint handling

    @RequestMapping(value = "/listartists", method = RequestMethod.GET)
    public String listArtists(Model model) {
        model.addAttribute("artist", artistRepo.findAll());
        return "listartists"; // listartists.html
    }

    @RequestMapping(value = "/editartist/{id}", method = RequestMethod.GET)
    public String editArtist(@PathVariable("id") Long id, Model model) {
        model.addAttribute("artist", artistRepo.findById(id));
        return "editartist"; // editartist.html
    }

    @RequestMapping(value = "/saveartist", method = RequestMethod.POST)
    public String saveArtist(Artist artist) {
        artistRepo.save(artist);
        return "redirect:/listartists"; // listartists.html
    }

    @RequestMapping(value = "/addartist", method = RequestMethod.GET)
    public String addArtist(Model model) {
        model.addAttribute("artist", new Artist());
        return "addartist"; // addartist.html
    }
}
