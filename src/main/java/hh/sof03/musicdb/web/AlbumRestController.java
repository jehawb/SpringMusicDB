package hh.sof03.musicdb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.sof03.musicdb.domain.Album;
import hh.sof03.musicdb.domain.AlbumRepository;

@CrossOrigin
@RestController
public class AlbumRestController {
    
    @Autowired
    AlbumRepository albumRepo;

    @RequestMapping(value = "/rest/albums", method = RequestMethod.GET)
    public @ResponseBody List<Album> albumListRest() {
        return (List<Album>) albumRepo.findAll();
    }
}
