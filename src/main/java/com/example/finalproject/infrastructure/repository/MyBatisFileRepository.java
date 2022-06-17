package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.application.files.FileEntity;
import com.example.finalproject.core.file.FileRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisFileRepository {

    @Autowired
    FileMapper fileMapper;

//    @Override
//    public void save(FileEntity file) {
//        fileMapper.insert(file);
//    }
}
