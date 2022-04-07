package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.core.premiere.Premiere;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PremiereMapper {
    void insert(@Param("premiere") Premiere premiere);
}
