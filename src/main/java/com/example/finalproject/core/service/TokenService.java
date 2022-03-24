package com.example.finalproject.core.service;

import java.util.Optional;

public interface TokenService {
    String generateToken(String subject);

    Optional<String> getSubFromToken(String token);
}
