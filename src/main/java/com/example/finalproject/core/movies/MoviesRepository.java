package com.example.finalproject.core.movies;

import com.example.finalproject.application.movies.MoviesList;

import java.util.ArrayList;

public interface MoviesRepository {
    void save(Movies movies);

    ArrayList<Movies> getMovies();

    Movies findById(String id);
}
