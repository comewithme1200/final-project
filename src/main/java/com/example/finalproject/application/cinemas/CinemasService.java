package com.example.finalproject.application.cinemas;

import com.example.finalproject.core.cinemas.Cinemas;
import com.example.finalproject.core.cinemas.CinemasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemasService {

    @Autowired
    public CinemasRepository cinemasRepository;

    public CinemaInfo create(CinemaCreateParam cinemaCreateParam){
        Cinemas cinema = new Cinemas(cinemaCreateParam.getCinema_name(), cinemaCreateParam.getCinema_address());
        cinemasRepository.save(cinema);
        return CinemaInfo.fromCinema(cinema);
    }

    public CinemaInfo getCinemaByRoomId(String room_id) {
        Cinemas cinema = cinemasRepository.getCinemaByRoomId(room_id);
        return CinemaInfo.fromCinema(cinema);
    }
}
