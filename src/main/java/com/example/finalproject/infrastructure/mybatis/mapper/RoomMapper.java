package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.application.room.RoomInfo;
import com.example.finalproject.core.rooms.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomMapper {
    void insert(@Param("room") Room room);

    List<RoomInfo> getAll();

    RoomInfo findRoomById(@Param("id") String id);
}
