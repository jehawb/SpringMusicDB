package hh.sof03.musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.musicdb.domain.AlbumRepository;
import hh.sof03.musicdb.domain.Song;
import hh.sof03.musicdb.domain.SongRepository;

@CrossOrigin
@Controller
public class SongController {

    // Repositories

    @Autowired
    private SongRepository songRepo;

    @Autowired
    private AlbumRepository albumRepo;

    // Endpoint handling

    @RequestMapping(value = "/songlist", method = RequestMethod.GET)
    public String songlist(Model model) {
        model.addAttribute("songs", songRepo.findAll());
        return "songlist"; // songlist.html
    }

    @RequestMapping(value = "/editsong/{id}", method = RequestMethod.GET)
    public String editsong(@PathVariable("id") Long id, Model model) {
        model.addAttribute("song", songRepo.findById(id));
        model.addAttribute("albums", albumRepo.findAll());
        return "editsong"; // editsong.html
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Song song) {
        songRepo.save(song);
        return "redirect:/songlist"; // songlist.html
    }

}
