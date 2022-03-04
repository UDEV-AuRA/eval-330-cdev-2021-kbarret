package com.ipiecoles.java.eval.th330.Controller;

import com.ipiecoles.java.eval.th330.model.Album;
import com.ipiecoles.java.eval.th330.service.AlbumService;
import com.ipiecoles.java.eval.th330.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class AlbumController {

    @Autowired

    private AlbumService albumService;


    @GetMapping("/artist/{id}/delete")
    public String deletealbum(@PathVariable("id") Long id, final ModelMap model){
        model.addAttribute("model", albumService.deleteAlbum(id));
        model.addAttribute("page", "accueilTemp");
        //model.addAttribute("fragment", "detailArtistTemp");
        return "indexTemp";
    }

    @GetMapping("/artist/{id}/add")
    public String ajoutalbum(Album album, final ModelMap model){;
        model.addAttribute("model", albumService.creerAlbum(album));
        model.addAttribute("page", "accueilTemp");
        //model.addAttribute("fragment", "detailArtistTemp");
        return "indexTemp";
    }
}
