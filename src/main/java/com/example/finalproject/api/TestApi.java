package com.example.finalproject.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
    @GetMapping(path = "test")
    public String hello() {
        return "hello";
    }
}
