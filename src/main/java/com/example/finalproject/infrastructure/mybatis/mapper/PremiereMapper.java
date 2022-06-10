package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.application.premiere.GetPremiereParam;
import com.example.finalproject.application.premiere.GetPremiereResponse;
import com.example.finalproject.core.premiere.Premiere;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Mapper
public interface PremiereMapper {
    void insert(@Param("premiere") Premiere premiere);

    ArrayList<Premiere> getAll();

    Premiere getPremiereById(@Param("id") String premiere_id);

    List<GetPremiereResponse> getPremiereMovie(@Param("movie_id") String movie_id, @Param("start_time") String start_time);

    void autoUpdatePremiere();
}
