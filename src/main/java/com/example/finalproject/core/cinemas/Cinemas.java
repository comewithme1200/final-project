package com.example.finalproject.core.cinemas;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public class Cinemas {
    private String id;
    private String cinema_name;
    private String cinema_address;

    public Cinemas(String cinema_name, String cinema_address) {
        this.id = UUID.randomUUID().toString();
        this.cinema_name = cinema_name;
        this.cinema_address = cinema_address;
    }
}
