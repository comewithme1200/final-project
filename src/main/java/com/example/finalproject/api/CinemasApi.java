package com.example.finalproject.api;

import com.example.finalproject.application.cinemas.CinemaCreateParam;
import com.example.finalproject.application.cinemas.CinemaInfo;
import com.example.finalproject.application.cinemas.CinemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinemas")
public class CinemasApi {

    @Autowired
    CinemasService cinemasService;

    @PostMapping(path = "/create")
    public CinemaInfo create(@RequestBody CinemaCreateParam cinemaCreateParam) {
        return cinemasService.create(cinemaCreateParam);
    }
}
