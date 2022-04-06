package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.core.seats.Seats;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SeatsMapper {
    void insert(@Param("seats") List<Seats> seatsList);
}
