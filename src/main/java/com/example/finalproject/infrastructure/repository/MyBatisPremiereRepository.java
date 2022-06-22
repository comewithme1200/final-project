package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.application.premiere.GetPremiereResponse;
import com.example.finalproject.application.premiere.PremiereFullInfo;
import com.example.finalproject.core.premiere.Premiere;
import com.example.finalproject.core.premiere.PremiereRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.PremiereMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public Premiere getPremiereById(String premiere_id) {
        return premiereMapper.getPremiereById(premiere_id);
    }

    @Override
    public List<GetPremiereResponse> getPremiereMovie(String movie_id, String date) {
        return premiereMapper.getPremiereMovie(movie_id, date);
    }

    @Override
    public void autoUpdatePremiere() {
        premiereMapper.autoUpdatePremiere();
    }

    @Override
    public List<PremiereFullInfo> getInfo() {
        return premiereMapper.getInfo();
    }

    @Override
    public PremiereFullInfo getById(String id) {
        return premiereMapper.getById(id);
    }

    @Override
    public void delete(String id) {
        premiereMapper.delete(id);
    }

}
