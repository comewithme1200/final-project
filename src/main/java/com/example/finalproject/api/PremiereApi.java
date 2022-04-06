package com.example.finalproject.api;

import com.example.finalproject.application.premiere.PremiereCreateParam;
import com.example.finalproject.application.premiere.PremiereInfo;
import com.example.finalproject.application.premiere.PremiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/premiere")
public class PremiereApi {

    @Autowired
    PremiereService premiereService;

    @PostMapping(path = "/create")
    public PremiereInfo createPremiere(@RequestBody PremiereCreateParam premiereCreateParam) {
        return premiereService.create(premiereCreateParam);
    }


}
