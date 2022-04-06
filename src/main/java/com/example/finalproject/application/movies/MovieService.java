package com.example.finalproject.application.movies;

import com.example.finalproject.core.movies.Movies;
import com.example.finalproject.core.movies.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
}
