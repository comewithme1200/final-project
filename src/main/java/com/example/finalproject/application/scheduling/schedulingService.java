package com.example.finalproject.application.scheduling;

import com.example.finalproject.core.premiere.PremiereRepository;
import com.example.finalproject.core.seats.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class schedulingService {

    @Autowired
    PremiereRepository premiereRepository;

    @Autowired
    SeatsRepository seatsRepository;


    @Scheduled(fixedRate = 300000)
    public void updatePremiereAndRelevant() {
        premiereRepository.autoUpdatePremiere();
        seatsRepository.autoUpdateSeatOccupied();
        System.out.println("Service run at " + new Date().toString());
    }
}
