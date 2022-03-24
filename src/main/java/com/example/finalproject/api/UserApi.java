package com.example.finalproject.api;

import com.example.finalproject.application.user.UserData;
import com.example.finalproject.application.user.UserRegisterParam;
import com.example.finalproject.application.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserApi {

    @Autowired
    UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public UserData createUser(@Valid @RequestBody UserRegisterParam registerParam) {
        return userService.createUser(registerParam);
    }


}
