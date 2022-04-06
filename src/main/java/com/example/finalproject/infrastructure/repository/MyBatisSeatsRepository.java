package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.core.seats.Seats;
import com.example.finalproject.core.seats.SeatsRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.SeatsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisSeatsRepository implements SeatsRepository {

    @Autowired
    SeatsMapper seatsMapper;

    @Override
    public void autoRenderSeats(List<Seats> seatsList) {
        seatsMapper.insert(seatsList);
    }
}
