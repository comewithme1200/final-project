package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.core.cinemas.Cinemas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CinemasMapper {
    void insert(@Param("cinema") Cinemas cinemas);
}
