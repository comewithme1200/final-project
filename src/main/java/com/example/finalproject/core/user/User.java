package com.example.finalproject.core.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
    private Date dob;
    private String address;
    private String role;

    public User(String email, String password, String name, String level, String phoneNumber, Date dob,
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

    public User(String email, String password, String name, String level, String phoneNumber, Date dob,
                String address, String role) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
        this.name = name;
        this.level = level;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.address = address;
        this.role = role;
    }

    public User(String email, String password, String name, String phoneNumber, Date dob, String address) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.address = address;
    }
}
