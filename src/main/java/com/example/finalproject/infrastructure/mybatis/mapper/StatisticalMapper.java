package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.application.statistical.CinemaTurnOver;
import com.example.finalproject.application.statistical.MovieTurnOver;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticalMapper {
    List<MovieTurnOver> getMovieTurnover();

    List<CinemaTurnOver> getCinemaTurnover();

    Long getTurnover();
}
