package com.example.finalproject.infrastructure.service;

import com.example.finalproject.core.user.EncryptSerivce;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptService implements EncryptSerivce {
    private BCryptPasswordEncoder passwordEncoder;

    public BCryptService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encryptPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    @Override
    public boolean checkPassword(String checkPassword, String encryptedPassword) {
        return passwordEncoder.matches(checkPassword, encryptedPassword);
    }
}
