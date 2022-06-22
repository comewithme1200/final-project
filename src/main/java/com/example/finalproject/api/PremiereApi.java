package com.example.finalproject.api;

import com.example.finalproject.api.exception.InvalidAuthenticationException;
import com.example.finalproject.api.exception.InvalidPremiereException;
import com.example.finalproject.application.premiere.*;
import com.example.finalproject.core.premiere.Premiere;
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
    public PremiereInfo createPremiere(@RequestBody PremiereCreateParam premiereCreateParam) throws InvalidPremiereException {
        return premiereService.create(premiereCreateParam);
    }

    @GetMapping()
    public ArrayList<Premiere> getAllPremiere() {
        return premiereService.getAll();
    }

    @GetMapping("/movie")
    public List<GetPremiereResponse> getPremiereOfMovie(@RequestParam String movie_id, @RequestParam String date) {
        return premiereService.getPremiereMovie(movie_id, date);
    }

    @PutMapping
    public PremiereInfo updatePremiere(@RequestBody PremiereCreateParam premiereCreateParam, @RequestParam String id) throws InvalidPremiereException {
        return premiereService.update(premiereCreateParam, id);
    }

    @GetMapping("/getInfo")
    public List<PremiereFullInfo> getInfo() {
        return premiereService.getInfo();
    }

    @GetMapping("/getById")
    public PremiereFullInfo getById(@RequestParam String id) {
        return premiereService.getById(id);
    }
}
