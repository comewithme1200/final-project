package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.application.cinemas.CinemaInfo;
import com.example.finalproject.core.cinemas.Cinemas;
import com.example.finalproject.core.cinemas.CinemasRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.CinemasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisCinemasRepository implements CinemasRepository {

    @Autowired
    CinemasMapper cinemasMapper;

    @Override
    public void save(Cinemas cinemas) {
        cinemasMapper.insert(cinemas);
    }
}
