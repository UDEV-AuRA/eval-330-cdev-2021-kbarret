package com.ipiecoles.java.eval.th330.Controller;

import com.ipiecoles.java.eval.th330.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class HomeController {
    @Autowired
    private ArtistService artistService;

    @GetMapping("/")
    public String index(final ModelMap model){
        //model.addAttribute("nombreArtist", artistService.countAllArtists());
        model.addAttribute("page", "accueilTemp");
        model.addAttribute("fragment", "accueilTemp");
        return "indexTemp";
    }

}

