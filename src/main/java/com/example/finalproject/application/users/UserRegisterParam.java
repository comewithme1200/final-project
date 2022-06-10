package com.example.finalproject.application.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterParam {
    @NotBlank(message = "can't be empty")
    @Email(message = "should be an email")
    @DuplicatedEmailConstraint
    private String email;

    @NotBlank(message = "can't be empty")
    private String password;

    @NotBlank(message = "can't be empty")
    private String name;

    @NotBlank(message = "can't be empty")
    @PhoneNumberConstraint
    private String phoneNumber;

    private Date dob;

    private String address;
}
