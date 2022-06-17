package com.example.finalproject.application.premiere;

import com.example.finalproject.api.exception.InvalidAuthenticationException;
import com.example.finalproject.api.exception.InvalidPremiereException;
import com.example.finalproject.core.premiere.Premiere;
import com.example.finalproject.core.premiere.PremiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PremiereService {

    @Autowired
    PremiereRepository premiereRepository;

    public PremiereInfo create(PremiereCreateParam premiereCreateParam) throws InvalidPremiereException {
        List<PremiereFullInfo> premiereFullInfos = premiereRepository.getInfo();
        for (PremiereFullInfo premiereFullInfo : premiereFullInfos) {
            if (premiereFullInfo.getStart_time().compareTo(premiereCreateParam.getEnd_time()) < 0  && premiereCreateParam.getStart_time().compareTo(premiereFullInfo.getEnd_time()) < 0
            && premiereFullInfo.getRoom_id().equals(premiereCreateParam.getRoom_id())) {
                throw new InvalidPremiereException();
            }
        }
        Premiere premiere = new Premiere(premiereCreateParam.getStart_time(), premiereCreateParam.getEnd_time(),
                premiereCreateParam.getMovie_id(), premiereCreateParam.getRoom_id());
        premiereRepository.save(premiere);
        return PremiereInfo.fromPremiere(premiere);
    }

    public ArrayList<Premiere> getAll() {
        return premiereRepository.getAll();
    }

    public List<GetPremiereResponse> getPremiereMovie(String movie_id, String date) {
        return premiereRepository.getPremiereMovie(movie_id, date);
    }

    public List<PremiereFullInfo> getInfo() {
        return premiereRepository.getInfo();
    }
}
