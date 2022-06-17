package com.example.finalproject.application.statistical;

import com.example.finalproject.core.statistical.StatisticalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticalService {

    @Autowired
    StatisticalRepository statisticalRepository;

    public List<MovieTurnOver> getMovieTurnover() {
        return statisticalRepository.getMovieTurnover();
    }

    public List<CinemaTurnOver> getCinemaTurnover() {
        return statisticalRepository.getCinemaTurnover();
    }

    public Long getTurnover() {
        return statisticalRepository.getTurnover();
    }
}
