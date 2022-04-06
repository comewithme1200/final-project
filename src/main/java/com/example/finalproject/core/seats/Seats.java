package com.example.finalproject.core.seats;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Seats {
    private String id;
    private int number;
    private String rows_alphabet;
    private String room_id;

    public Seats(int number, String rows_alphabet, String room_id) {
        this.id = UUID.randomUUID().toString();
        this.number = number;
        this.rows_alphabet = rows_alphabet;
        this.room_id = room_id;
    }
}
