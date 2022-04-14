package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.application.seats.SeatRows;
import com.example.finalproject.core.seats.SeatOccupied;
import com.example.finalproject.core.seats.Seats;
import com.example.finalproject.core.seats.SeatsRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.SeatsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MyBatisSeatsRepository implements SeatsRepository {

    @Autowired
    SeatsMapper seatsMapper;

    @Override
    public void autoRenderSeats(List<Seats> seatsList) {
        seatsMapper.insert(seatsList);
    }

    @Override
    public ArrayList<SeatOccupied> getSeatsPremiere(String premiere_id) {
        return seatsMapper.getSeatsPremiere(premiere_id);
    }

    @Override
    public boolean existsSeatOccupied(String seat_id, String premiere_id) {
        return seatsMapper.existsSeatOccupied(seat_id, premiere_id);
    }

    @Override
    public void insertSeatOccupied(List<SeatOccupied> seatOccupiedList) {
        seatsMapper.insertSeatOccupied(seatOccupiedList);
    }

    @Override
    public List<SeatRows> getSeatsStatus(String roomId, String premiereId) {
        return seatsMapper.getSeatsStatus(roomId, premiereId);
    }
}
