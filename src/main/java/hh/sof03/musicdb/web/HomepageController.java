package hh.sof03.musicdb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage() {
        return "home"; // home.html
    }
    
}
