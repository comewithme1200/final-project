package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.core.movies.Movies;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface MoviesMapper {
    void insert(@Param("movie") Movies movies);

    ArrayList<Movies> getMovies();

    Movies findById(@Param("id") String id);
}
