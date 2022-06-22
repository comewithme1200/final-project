package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.application.users.UpdateParam;
import com.example.finalproject.core.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    void insert(@Param("user") User user);

    User findById(@Param("id") String id);

    User findByUsername(@Param("username") String username);

    User findByEmail(@Param("email") String email);

    void updateLevel(@Param("level") String level, @Param("user_id") String user_id);

    List<User> getAdmin();

    void update(@Param("user") UpdateParam updateParam, @Param("id") String id);

    List<User> filter(@Param("query") String query);
}
