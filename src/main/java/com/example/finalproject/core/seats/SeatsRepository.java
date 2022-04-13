package com.example.finalproject.core.seats;

import com.example.finalproject.application.seats.SeatData;
import com.example.finalproject.application.seats.SeatRow;

import java.util.ArrayList;
import java.util.List;


public interface SeatsRepository {
    void autoRenderSeats(List<Seats> seatsList);

    ArrayList<SeatData> getSeat(String roomId);

    ArrayList<SeatRow> getSeatRow(String roomId);

    ArrayList<SeatOccupied> getSeatsPremiere(String premiere_id);
}
