package com.example.finalproject.core.premiere;

import com.example.finalproject.application.premiere.GetPremiereResponse;

import java.util.ArrayList;

public interface PremiereRepository {
    void save(Premiere premiere);

    ArrayList<Premiere> getAll();

    ArrayList<GetPremiereResponse> getPremiereList(String movie_id, String date);
}
