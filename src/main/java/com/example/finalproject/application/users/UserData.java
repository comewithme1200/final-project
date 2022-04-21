package com.example.finalproject.application.users;

import com.example.finalproject.core.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserData {
    private String id;
    private String email;
    private String name;
    private String level;

    public static UserData fromUser(User user) {
        return new UserData(
            user.getId(),
            user.getEmail(),
            user.getName(),
            user.getLevel()
        );
    }
}
