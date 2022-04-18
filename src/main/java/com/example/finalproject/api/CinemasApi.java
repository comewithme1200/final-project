package com.example.finalproject.api;

import com.example.finalproject.application.cinemas.CinemaCreateParam;
import com.example.finalproject.application.cinemas.CinemaInfo;
import com.example.finalproject.application.cinemas.CinemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cinemas")
public class CinemasApi {

    @Autowired
    CinemasService cinemasService;

    @PostMapping(path = "/create")
    public CinemaInfo create(@RequestBody CinemaCreateParam cinemaCreateParam) {
        return cinemasService.create(cinemaCreateParam);
    }

    @GetMapping
    public CinemaInfo getCinemaByRoomId(@RequestParam String room_id) {
        return cinemasService.getCinemaByRoomId(room_id);
    }
}
