package com.example.finalproject.core.premiere;

import com.example.finalproject.application.premiere.GetPremiereResponse;
import com.example.finalproject.application.premiere.PremiereFullInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface PremiereRepository {
    void save(Premiere premiere);

    ArrayList<Premiere> getAll();

    Premiere getPremiereById(String premiere_id);

    List<GetPremiereResponse> getPremiereMovie(String movie_id, String date);

    void autoUpdatePremiere();

    List<PremiereFullInfo> getInfo();
}
