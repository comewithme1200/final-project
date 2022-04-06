package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.core.movies.Movies;
import com.example.finalproject.core.movies.MoviesRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.MoviesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisMovieRepository implements MoviesRepository {

    @Autowired
    MoviesMapper moviesMapper;

    @Override
    public void save(Movies movies) {
        moviesMapper.insert(movies);
    }
}
