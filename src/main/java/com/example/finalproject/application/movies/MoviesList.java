package com.example.finalproject.application.movies;

import com.example.finalproject.core.movies.Movies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesList {
    private ArrayList<Movies> moviesAboutOnAir;
    private ArrayList<Movies> moviesOnAir;
}
