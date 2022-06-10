package com.example.finalproject.api;

import com.example.finalproject.application.movies.MovieCreateParam;
import com.example.finalproject.application.movies.MovieService;
import com.example.finalproject.application.movies.MoviesList;
import com.example.finalproject.application.premiere.PremiereCreateParam;
import com.example.finalproject.application.premiere.PremiereInfo;
import com.example.finalproject.application.premiere.PremiereService;
import com.example.finalproject.core.movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/movies")
public class MoviesApi {

    @Autowired
    MovieService movieService;

    @PostMapping()
    public Movies create(@Valid @RequestBody MovieCreateParam movieCreateParam) {
        return movieService.create(movieCreateParam);
    }

    @GetMapping()
    public MoviesList getMoviesList() {
        return movieService.getMovies();
    }

    @GetMapping("/getMovieInfo")
    public Movies getMovieById(@RequestParam String id) {
        return movieService.getMovieById(id);
    }

}
