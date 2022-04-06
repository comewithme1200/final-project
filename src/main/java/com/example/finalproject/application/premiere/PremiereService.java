package com.example.finalproject.application.premiere;

import org.springframework.stereotype.Service;

@Service
public class PremiereService {
    public PremiereInfo create(PremiereCreateParam premiereCreateParam) {
        PremiereInfo premiereInfo = new PremiereInfo();
        return premiereInfo;
    }

}
