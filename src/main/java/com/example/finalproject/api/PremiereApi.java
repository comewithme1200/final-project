package com.example.finalproject.api;

import com.example.finalproject.application.premiere.*;
import com.example.finalproject.core.premiere.Premiere;
import com.example.finalproject.core.premiere.PremiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/movie")
    public List<GetPremiereResponse> getPremiereOfMovie(@RequestParam String movie_id, @RequestParam String date) {
        return premiereService.getPremiereMovie(movie_id, date);
    }
}
