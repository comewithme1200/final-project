package com.example.finalproject.core.premiere;

import com.example.finalproject.application.premiere.GetPremiereResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface PremiereRepository {
    void save(Premiere premiere);

    ArrayList<Premiere> getAll();

    List<GetPremiereResponse> getPremiereMovie(String movie_id, String date);

    void autoUpdatePremiere();
}
