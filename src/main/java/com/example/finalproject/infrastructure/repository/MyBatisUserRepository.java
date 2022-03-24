package com.example.finalproject.infrastructure.repository;


import com.example.finalproject.core.user.User;
import com.example.finalproject.core.user.UserRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MyBatisUserRepository implements UserRepository {

    @Autowired
    UserMapper userMapper;

    @Override
    public void save(User user) {

    }

    @Override
    public Optional<User> findById(String id) {
        User user = userMapper.findById(id);
        if (user != null)
            return Optional.of(user);
        return Optional.empty();
    }
}
