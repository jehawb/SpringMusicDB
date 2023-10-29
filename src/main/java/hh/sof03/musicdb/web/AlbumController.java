package hh.sof03.musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.musicdb.domain.AlbumRepository;

@CrossOrigin
@Controller
public class AlbumController {
    
    // Repositories

    @Autowired
    private AlbumRepository albumRepo;

    // Endpoint handling

    @RequestMapping(value = "/albumlist", method = RequestMethod.GET)
    public String albumlist(Model model) {
        model.addAttribute("albums", albumRepo.findAll());
        return "albumlist"; // albumlist.html
    }
}
