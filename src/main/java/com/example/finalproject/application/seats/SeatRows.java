package com.example.finalproject.application.seats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeatRows {
    private String rows_alphabet;
    private ArrayList<SeatNumber> seatNumberArrayList;
}
