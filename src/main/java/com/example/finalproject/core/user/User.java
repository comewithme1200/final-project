package com.example.finalproject.core.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public class User {
    private String id;
    private String email;
    private String password;
    private String name;
    private String level;
    private String phoneNumber;
    private String dob;
    private String address;

    public User(String email, String password, String name, String level, String phoneNumber, String dob,
                String address) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
        this.name = name;
        this.level = level;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.address = address;
    }

    public User(String email, String password) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
    }
}
