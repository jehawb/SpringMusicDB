package hh.sof03.musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.musicdb.domain.Album;
import hh.sof03.musicdb.domain.AlbumRepository;
import hh.sof03.musicdb.domain.ArtistRepository;

@CrossOrigin
@Controller
public class AlbumController {
    
    // Repositories

    @Autowired
    private AlbumRepository albumRepo;

    @Autowired
    private ArtistRepository artistRepo;

    // Endpoint handling

    @RequestMapping(value = "/listalbums", method = RequestMethod.GET)
    public String listAlbums(Model model) {
        model.addAttribute("albums", albumRepo.findAll());
        return "listalbums"; // listalbums.html
    }

    @RequestMapping(value = "/editalbum/{id}", method = RequestMethod.GET)
    public String editAlbum(@PathVariable("id") Long id, Model model) {
        model.addAttribute("album", albumRepo.findById(id));
        model.addAttribute("artists", artistRepo.findAll());
        return "editalbum"; // editalbum.html
    }

    @RequestMapping(value = "/savealbum", method = RequestMethod.POST)
    public String saveAlbum(Album album) {
        albumRepo.save(album);
        return "redirect:/listalbums"; // listalbums.html
    }

    @RequestMapping(value = "/addalbum", method = RequestMethod.GET)
    public String addAlbum(Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("artists", artistRepo.findAll());
        return "addalbum"; // addalbum.html
    }

    @RequestMapping(value = "/deletealbum/{id}", method = RequestMethod.GET)
    public String deleteAlbum(@PathVariable("id") Long id, Model model) {
        albumRepo.deleteById(id);
        return "redirect:/listalbums"; // listalbums.html
    }
}
