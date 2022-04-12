package com.example.finalproject.application.premiere;

import com.example.finalproject.core.premiere.Premiere;
import com.example.finalproject.core.premiere.PremiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PremiereService {

    @Autowired
    PremiereRepository premiereRepository;

    public PremiereInfo create(PremiereCreateParam premiereCreateParam) {
        Premiere premiere = new Premiere(premiereCreateParam.getStart_time(), premiereCreateParam.getEnd_time(),
                premiereCreateParam.getMovie_id(), premiereCreateParam.getRoom_id());
        premiereRepository.save(premiere);
        return PremiereInfo.fromPremiere(premiere);
    }

    public ArrayList<Premiere> getAll() {
        return premiereRepository.getAll();
    }

    public ArrayList<GetPremiereResponse> getPremiereList(String movie_id, String date) {
        return premiereRepository.getPremiereList(movie_id, date);
    }

}
