package com.example.finalproject.core.movies;

import com.example.finalproject.application.movies.MoviesList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MoviesRepository {
    void save(Movies movies);

    ArrayList<Movies> getMovies();

    Movies findById(String id);

    List<Movies> getAll();

    List<Movies> filter(String query);

    Optional<Movies> findByName(String name);

    void update(Movies movies, String id);

    void delete(String id);
}
