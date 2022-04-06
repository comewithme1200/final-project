package com.example.finalproject.application.users;

import lombok.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
}
