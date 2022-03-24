package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.core.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void insert(@Param("user") User user);

    User findById(@Param("id") String id);
}
