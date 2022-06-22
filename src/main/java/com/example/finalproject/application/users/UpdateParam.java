package com.example.finalproject.application.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateParam {
    private String email;
    private String name;
    private String phoneNumber;
    private Date dob;
    private String address;
}
