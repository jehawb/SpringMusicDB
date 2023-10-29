package hh.sof03.musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
