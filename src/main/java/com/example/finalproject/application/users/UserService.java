package com.example.finalproject.application.users;

import com.example.finalproject.core.user.EncryptSerivce;
import com.example.finalproject.core.user.User;
import com.example.finalproject.core.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private EncryptSerivce encryptSerivce;

    @Autowired
    private UserRepository userRepository;


    public UserData createUser(@Valid UserRegisterParam userRegisterParam) {
        User user = new User(
                userRegisterParam.getEmail(),
                encryptSerivce.encryptPassword(userRegisterParam.getPassword())
        );
        userRepository.save(user);
        return UserData.fromUser(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
