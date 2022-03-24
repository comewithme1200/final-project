package com.example.finalproject.infrastructure.service;

import com.example.finalproject.core.service.TokenService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtService implements TokenService {

    private String secret;

    private int sessionTime;

    @Autowired
    public JwtService(@Value("${jwt.secret}") String secret, @Value("${jwt.sessionTime}") int sessionTime) {
        this.secret = secret;
        this.sessionTime = sessionTime;
    }

    @Override
    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(expireTimeFromNow())
                .signWith(SignatureAlgorithm.ES512, secret)
                .compact();
    }

    @Override
    public Optional<String> getSubFromToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return Optional.ofNullable(claimsJws.getBody().getSubject());
        } catch (Exception e) {
            return Optional.empty();
        }
    }


    private Date expireTimeFromNow() {
        return new Date(System.currentTimeMillis() + this.sessionTime * 1000);
    }
}
