package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.application.movies.MoviesList;
import com.example.finalproject.core.movies.Movies;
import com.example.finalproject.core.movies.MoviesRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.MoviesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MyBatisMovieRepository implements MoviesRepository {

    @Autowired
    MoviesMapper moviesMapper;

    @Override
    public void save(Movies movies) {
        moviesMapper.insert(movies);
    }

    @Override
    public ArrayList<Movies> getMovies() {
        return moviesMapper.getMovies();
    }

    @Override
    public Movies findById(String id) {
        return moviesMapper.findById(id);
    }

    @Override
    public List<Movies> getAll() {
        return moviesMapper.getAll();
    }

    @Override
    public List<Movies> filter(String query) {
        return moviesMapper.filter("%" + query + "%");
    }

    @Override
    public Optional<Movies> findByName(String name) {
        return moviesMapper.findByName(name);
    }
}
