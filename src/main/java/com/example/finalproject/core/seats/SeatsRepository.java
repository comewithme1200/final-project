package com.example.finalproject.core.seats;

import com.example.finalproject.application.seats.SeatData;
import com.example.finalproject.application.seats.SeatRow;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;


public interface SeatsRepository {
    void autoRenderSeats(List<Seats> seatsList);

    ArrayList<SeatData> getSeat(String roomId);

    ArrayList<SeatRow> getSeatRow(String roomId);

    ArrayList<SeatOccupied> getSeatsPremiere(String premiere_id);

    boolean existsSeatOccupied(String seat_id, String premiere_id);

    void insertSeatOccupied(@Param("seatOccupiedList") List<SeatOccupied> seatOccupiedList);
}
