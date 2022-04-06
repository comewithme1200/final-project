package com.example.finalproject.application.cinemas;

import com.example.finalproject.core.cinemas.Cinemas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CinemaInfo {
    private String id;
    private String cinema_name;
    private String cinema_address;

    public static CinemaInfo fromCinema(Cinemas cinemas) {
        return new CinemaInfo(cinemas.getId(),
        cinemas.getCinema_name(),
        cinemas.getCinema_address());
    }
}
