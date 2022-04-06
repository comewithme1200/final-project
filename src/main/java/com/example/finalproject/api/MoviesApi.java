package com.example.finalproject.api;

import com.example.finalproject.application.movies.MovieCreateParam;
import com.example.finalproject.application.movies.MovieService;
import com.example.finalproject.core.movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/movies")
public class MoviesApi {

    @Autowired
    MovieService movieService;

    @PostMapping(path = "/create")
    public Movies create(@Valid @RequestBody MovieCreateParam movieCreateParam) {
        return movieService.create(movieCreateParam);
    }

}
