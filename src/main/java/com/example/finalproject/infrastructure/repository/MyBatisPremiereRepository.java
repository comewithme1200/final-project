package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.application.premiere.GetPremiereResponse;
import com.example.finalproject.core.premiere.Premiere;
import com.example.finalproject.core.premiere.PremiereRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.PremiereMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MyBatisPremiereRepository implements PremiereRepository {

    @Autowired
    PremiereMapper premiereMapper;

    @Override
    public void save(Premiere premiere) {
        premiereMapper.insert(premiere);
    }

    @Override
    public ArrayList<Premiere> getAll() {
        return premiereMapper.getAll();
    }

    @Override
    public ArrayList<GetPremiereResponse> getPremiereList(String movie_id, String date) {
        return premiereMapper.getPremiereList(movie_id, date);
    }
}
