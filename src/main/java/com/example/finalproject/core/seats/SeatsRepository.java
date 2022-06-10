package com.example.finalproject.core.seats;

import com.example.finalproject.application.room.RoomInfo;
import com.example.finalproject.application.seats.SeatRows;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;


public interface SeatsRepository {
    void autoRenderSeats(List<Seats> seatsList);

    ArrayList<SeatOccupied> getSeatsPremiere(String premiere_id);

    List<Integer> getNumberOfSeatOccupied(String premiere_id);

    boolean existsSeatOccupied(String seat_id, String premiere_id);

    void insertSeatOccupied(@Param("seatOccupiedList") List<SeatOccupied> seatOccupiedList);

    Seats getSeatNameById(String seat_id);

    List<SeatRows> getSeatsStatus(@Param("roomId") String roomId, @Param("premiereId") String premiereId);

    void autoUpdateSeatOccupied();

    void update(List<SeatOccupied> seatOccupieds);

    void delete(List<SeatOccupied> seatOccupieds);
}
