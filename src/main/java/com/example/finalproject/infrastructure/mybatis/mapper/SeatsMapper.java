package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.application.seats.GetSeatParam;
import com.example.finalproject.application.seats.SeatData;
import com.example.finalproject.application.seats.SeatRow;
import com.example.finalproject.application.seats.SeatRows;
import com.example.finalproject.core.seats.Seats;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface SeatsMapper {
    void insert(@Param("seats") List<Seats> seatsList);

    ArrayList<SeatData> getSeats(@Param("roomId") String roomId);

    ArrayList<SeatRow> getSeatRow(@Param("roomId") String roomId);
}
