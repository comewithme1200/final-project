package com.example.finalproject.api;

import com.example.finalproject.application.premiere.GetPremiereParam;
import com.example.finalproject.application.premiere.PremiereCreateParam;
import com.example.finalproject.application.premiere.PremiereInfo;
import com.example.finalproject.application.premiere.PremiereService;
import com.example.finalproject.core.premiere.Premiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/premiere")
public class PremiereApi {

    @Autowired
    PremiereService premiereService;

    @PostMapping(path = "/create")
    public PremiereInfo createPremiere(@RequestBody PremiereCreateParam premiereCreateParam) {
        return premiereService.create(premiereCreateParam);
    }

//    @GetMapping()
//    public ArrayList<Premiere> getPremiereList(@RequestParam String movie_id, @RequestParam String date) {
//        return premiereService.getPremiereList(movie_id, date);
//    }

    @GetMapping()
    public ArrayList<Premiere> getAllPremiere() {
        return premiereService.getAll();
    }

}
