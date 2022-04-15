package com.example.finalproject.application.movies;

import com.example.finalproject.core.movies.Movies;
import com.example.finalproject.core.movies.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class MovieService {

    @Autowired
    MoviesRepository moviesRepository;

    public Movies create(MovieCreateParam movieCreateParam) {
        Movies movies = new Movies(movieCreateParam.getMovie_name()
                                    , movieCreateParam.getPremiere_date()
                                    , movieCreateParam.getDetail()
                                    , movieCreateParam.getTrailer_link()
                                    , movieCreateParam.getImage_path());
        moviesRepository.save(movies);
        return movies;
    }


    public MoviesList getMovies() {
        ArrayList<Movies> moviesArrayList;
        ArrayList<Movies> moviesAboutOnAir = new ArrayList<>();
        ArrayList<Movies> moviesOnAir = new ArrayList<>();
        moviesArrayList = moviesRepository.getMovies();

        for (Movies movies : moviesArrayList) {
            Date now = new Date();
            if (movies.getPremiere_date().before(now) || movies.getPremiere_date().equals(now)) {
                moviesOnAir.add(movies);
            } else if (movies.getPremiere_date().after(now)) {
                moviesAboutOnAir.add(movies);
            }
        }

        MoviesList moviesList = new MoviesList(moviesAboutOnAir, moviesOnAir);

        return moviesList;
    }

    public Movies getMovieById(String id) {
        return moviesRepository.findById(id);
    }
}
