package com.example.finalproject.application.seats;

import com.example.finalproject.core.seats.Seats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatData {
    private String id;
    private int number;
    private String rows_alphabet;

    public static SeatData fromSeat(Seats seats) {
        return new SeatData(
          seats.getId(),
          seats.getNumber(),
          seats.getRows_alphabet()
        );
    }
}
