package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.application.seats.SeatRows;
import com.example.finalproject.core.seats.SeatOccupied;
import com.example.finalproject.core.seats.Seats;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface SeatsMapper {
    void insert(@Param("seats") List<Seats> seatsList);

    ArrayList<SeatOccupied> getSeatsPremiere(@Param("premiereId") String premiereId);

    List<Integer> getNumberOfSeatOccupied(@Param("premiereId") String premiereId);

    boolean existsSeatOccupied(@Param("seatId") String seatId, @Param("premiereId") String premiereId);

    void insertSeatOccupied(@Param("seatOccupiedList") List<SeatOccupied> seatOccupiedList);

    Seats getSeatNameById(@Param("id") String seat_id);

    List<SeatRows> getSeatsStatus(@Param("roomId") String roomId, @Param("premiereId") String premiereId);

    void autoUpdateSeatOccupied();

    void update(@Param("seats") List<SeatOccupied> seatOccupieds);

    void delete(@Param("seats") List<SeatOccupied> seatOccupieds);
}
