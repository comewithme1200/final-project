package com.example.finalproject.infrastructure.repository;


import com.example.finalproject.application.users.UpdateParam;
import com.example.finalproject.core.user.User;
import com.example.finalproject.core.user.UserRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MyBatisUserRepository implements UserRepository {

    final
    UserMapper userMapper;

    public MyBatisUserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public Optional<User> findById(String id) {
        User user = userMapper.findById(id);
        if (user != null)
            return Optional.of(user);
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        if (user != null)
            return Optional.of(user);
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = userMapper.findByEmail(email);
        if (user != null)
            return Optional.of(user);
        return Optional.empty();
    }

    @Override
    public void updateLevel(String level, String user_id) {
        userMapper.updateLevel(level, user_id);
    }

    @Override
    public void update(UpdateParam updateParam, String id) {
        userMapper.update(updateParam, id);
    }

    @Override
    public List<User> getAdmin() {
        return userMapper.getAdmin();
    }

    @Override
    public List<User> filter(String query) {
        return userMapper.filter("%" + query + "%").stream().filter(user -> user.getRole().equals("ad")).collect(Collectors.toList());
    }
}
