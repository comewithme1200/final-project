package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.application.files.FileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FileMapper {
    void insert(@Param("file") FileEntity file);
}
