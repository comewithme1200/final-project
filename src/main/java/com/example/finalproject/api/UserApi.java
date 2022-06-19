package com.example.finalproject.api;

import com.example.finalproject.api.exception.InvalidAuthenticationException;
import com.example.finalproject.application.users.*;
import com.example.finalproject.core.service.TokenService;
import com.example.finalproject.core.user.EncryptSerivce;
import com.example.finalproject.core.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserApi {

    @Autowired
    UserService userService;

    @Autowired
    EncryptSerivce encryptSerivce;

    @Autowired
    TokenService tokenService;

    @Autowired
    public UserApi(UserService userService, EncryptSerivce encryptSerivce, TokenService tokenService) {
        this.userService = userService;
        this.encryptSerivce = encryptSerivce;
        this.tokenService = tokenService;
    }


    @PostMapping(path = "/register")
    public UserData createUser(@Valid @RequestBody UserRegisterParam registerParam) {
        return userService.createUser(registerParam);
    }

    @PostMapping("/registerAdmin")
    public UserData createAdmin(@Valid @RequestBody UserRegisterParam registerParam) {
        return userService.createAdmin(registerParam);
    }

    @GetMapping
    public User getUserByToken(@AuthenticationPrincipal User user) {
        return user;
    }

    @GetMapping("/getUserById")
    public Optional<User> getUserById(@RequestParam String id) {
        return userService.findById(id);
    }

    @GetMapping("/getAdmin")
    public List<User> getAdmin() {
        return userService.getAdmin();
    }

    @PostMapping(path = "/login")
    public LoginResponse login(@Valid @RequestBody LoginParam loginParam) throws InvalidAuthenticationException {
        Optional<User> user = userService.findByEmail(loginParam.getEmail());
        if (user.isPresent() && encryptSerivce.checkPassword(loginParam.getPassword(),
                user.get().getPassword())) {
            String token = tokenService.generateToken(user.get().getId());
            UserData userData = UserData.fromUser(user.get());
            return new LoginResponse(token, userData);
        }
        else {
            throw new InvalidAuthenticationException();
        }
    }

    @PutMapping(path = "/updateLevel")
    public Optional<User> updateLevel(@AuthenticationPrincipal User user) {
        return userService.updateLevel(user);
    }

}
