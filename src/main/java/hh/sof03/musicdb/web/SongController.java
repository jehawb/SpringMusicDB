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

    @RequestMapping(value = "/listsongs", method = RequestMethod.GET)
    public String listSongs(Model model) {
        model.addAttribute("songs", songRepo.findAll());
        return "listsongs"; // listsongs.html
    }

    @RequestMapping(value = "/editsong/{id}", method = RequestMethod.GET)
    public String editSong(@PathVariable("id") Long id, Model model) {
        model.addAttribute("song", songRepo.findById(id));
        model.addAttribute("albums", albumRepo.findAll());
        return "editsong"; // editsong.html
    }

    @RequestMapping(value = "/savesong", method = RequestMethod.POST)
    public String saveSong(Song song) {
        songRepo.save(song);
        return "redirect:/listsongs"; // listsongs.html
    }

    @RequestMapping(value = "/addsong", method = RequestMethod.GET)
    public String addSong(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("albums", albumRepo.findAll());
        return "addsong"; // addsong.html
    }

    @RequestMapping(value = "/deletesong/{id}", method = RequestMethod.GET)
    public String deleteSong(@PathVariable("id") Long id, Model model) {
        songRepo.deleteById(id);
        return "redirect:/listsongs"; // listsongs.html
    }

    @RequestMapping(value = "/listsongs/{id}", method = RequestMethod.GET)
    public String listSongsOnAlbum(@PathVariable("id") Long id, Model model) {
        model.addAttribute("songs", songRepo.findByAlbumId(id));
        return "listsongs"; // listsongs.html
    }

}
