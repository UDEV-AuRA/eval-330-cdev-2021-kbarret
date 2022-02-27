package com.ipiecoles.java.eval.th330.Controller;


import com.ipiecoles.java.eval.th330.model.Artist;
import com.ipiecoles.java.eval.th330.service.AlbumService;
import com.ipiecoles.java.eval.th330.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArtistController {

    @Autowired

    private ArtistService artistService;


    @GetMapping("/artist/{id}")
    public String getArtistid(@PathVariable("id") Long id, final ModelMap model){
        model.addAttribute("model", artistService.findById(id));
        model.addAttribute("page", "detailArtistTemp");
        //model.addAttribute("fragment", "detailArtistTemp");
        return "indexTemp";
    }


    @GetMapping(value = "/artist")
    public String listArtists(final ModelMap model,
                               @RequestParam(defaultValue = "0") Integer page,
                               @RequestParam(defaultValue = "10") Integer size,
                               @RequestParam(defaultValue = "ASC") String sortDirection,
                               @RequestParam(defaultValue = "name") String sortProperty
    ){
        Page<Artist> allArtists = artistService.findAllArtists(page, size, sortProperty, sortDirection);
        model.addAttribute("model", allArtists);
        model.addAttribute("start", page * size + 1);
        model.addAttribute("end", (page + 1) * size);
        model.addAttribute("pageNumber", page + 1);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("previousPage", page - 1);
        model.addAttribute("page", "listeArtistsTemp");
        //model.addAttribute("fragment", "listeArtistsTemp");
        return "indexTemp";
    }
}
