package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.core.rooms.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoomMapper {
    void insert(@Param("room") Room room);
}
