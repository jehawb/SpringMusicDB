package hh.sof03.musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.musicdb.domain.AlbumRepository;
import hh.sof03.musicdb.domain.ArtistRepository;
import hh.sof03.musicdb.domain.SongRepository;

@Controller
public class SearchController {

    @Autowired
    ArtistRepository artistRepo;

    @Autowired
    AlbumRepository albumRepo;

    @Autowired
    SongRepository songRepo;

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public String search(@PathVariable("name") String name, Model model) {

        model.addAttribute("artists", artistRepo.findByNameLikeIgnoreCase("%" + name + "%"));
        model.addAttribute("albums", albumRepo.findByNameLikeIgnoreCase("%" + name + "%"));
        model.addAttribute("songs", songRepo.findByNameLikeIgnoreCase("%" + name + "%"));

        return "search"; // search.html
    }

}
