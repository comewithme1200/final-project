package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.application.statistical.CinemaTurnOver;
import com.example.finalproject.application.statistical.MovieTurnOver;
import com.example.finalproject.core.statistical.StatisticalRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.StatisticalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisStatisticRepository implements StatisticalRepository {

    @Autowired
    StatisticalMapper statisticalMapper;

    @Override
    public List<MovieTurnOver> getMovieTurnover() {
        return statisticalMapper.getMovieTurnover();
    }

    @Override
    public List<CinemaTurnOver> getCinemaTurnover() {
        return statisticalMapper.getCinemaTurnover();
    }

    @Override
    public Long getTurnover() {
        return statisticalMapper.getTurnover();
    }
}
