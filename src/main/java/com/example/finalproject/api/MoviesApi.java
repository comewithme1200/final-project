package com.example.finalproject.api;

import com.example.finalproject.application.movies.MovieCreateParam;
import com.example.finalproject.application.movies.MovieService;
import com.example.finalproject.application.movies.MoviesList;
import com.example.finalproject.core.movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesApi {

    @Autowired
    MovieService movieService;

    @PostMapping()
    public Movies create(@Valid @RequestPart MovieCreateParam movieCreateParam, @RequestPart("file") MultipartFile file) throws IOException {
        return movieService.create(movieCreateParam, file);
    }

    @GetMapping()
    public MoviesList getMoviesList() {
        return movieService.getMovies();
    }

    @GetMapping("/getAll")
    public List<Movies> getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping("/getMovieInfo")
    public Movies getMovieById(@RequestParam String id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/filter")
    public List<Movies> filter(@RequestParam String query) {
        return movieService.filter(query);
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id){
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(movieService.getImage(id));
    }
}
