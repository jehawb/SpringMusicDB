package hh.sof03.musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hh.sof03.musicdb.domain.AlbumRepository;
import hh.sof03.musicdb.domain.ArtistRepository;
import hh.sof03.musicdb.domain.SongRepository;

@Controller
public class SearchController {

    // Repositories

    @Autowired
    ArtistRepository artistRepo;

    @Autowired
    AlbumRepository albumRepo;

    @Autowired
    SongRepository songRepo;

    // Endpoint handling

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("keyword") String keyword, Model model) {

        // %name% form needed for "like" search operations
        model.addAttribute("artists", artistRepo.findByNameLikeIgnoreCase("%" + keyword + "%"));
        model.addAttribute("albums", albumRepo.findByNameLikeIgnoreCase("%" + keyword + "%"));
        model.addAttribute("songs", songRepo.findByNameLikeIgnoreCase("%" + keyword + "%"));

        return "search"; // search.html
    }

}
