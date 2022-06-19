package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.core.movies.Movies;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mapper
public interface MoviesMapper {
    void insert(@Param("movie") Movies movies);

    ArrayList<Movies> getMovies();

    Movies findById(@Param("id") String id);

    List<Movies> getAll();

    List<Movies> filter(@Param("query") String query);

    Optional<Movies> findByName(@Param("name") String name);

    void update(@Param("movie") Movies movies, @Param("id") String id);

    void delete(@Param("id") String id);
}
