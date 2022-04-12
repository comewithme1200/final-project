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
    private String status;

    public Seats(int number, String rows_alphabet, String room_id, String status) {
        this.id = UUID.randomUUID().toString();
        this.number = number;
        this.rows_alphabet = rows_alphabet;
        this.room_id = room_id;
        this.status = status;
    }
}
