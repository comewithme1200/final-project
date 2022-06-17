package com.example.finalproject.core.statistical;

import com.example.finalproject.application.statistical.CinemaTurnOver;
import com.example.finalproject.application.statistical.MovieTurnOver;

import java.util.List;

public interface StatisticalRepository {
    List<MovieTurnOver> getMovieTurnover();

    List<CinemaTurnOver> getCinemaTurnover();

    Long getTurnover();
}
