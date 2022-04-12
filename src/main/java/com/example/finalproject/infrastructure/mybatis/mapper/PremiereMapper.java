package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.application.premiere.GetPremiereParam;
import com.example.finalproject.application.premiere.GetPremiereResponse;
import com.example.finalproject.core.premiere.Premiere;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface PremiereMapper {
    void insert(@Param("premiere") Premiere premiere);

    ArrayList<Premiere> getAll();

    ArrayList<GetPremiereResponse> getPremiereList(@Param("movie_id") String movie_id, @Param("date") String date);
}
