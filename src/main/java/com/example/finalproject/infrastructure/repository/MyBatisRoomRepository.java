package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.application.room.RoomInfo;
import com.example.finalproject.core.rooms.Room;
import com.example.finalproject.core.rooms.RoomRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisRoomRepository implements RoomRepository {

    @Autowired
    RoomMapper roomMapper;

    @Override
    public void save(Room room) {
        roomMapper.insert(room);
    }

    @Override
    public List<RoomInfo> getAll() {
        return roomMapper.getAll();
    }

    @Override
    public RoomInfo findRoomById(String id) {
        return roomMapper.findRoomById(id);
    }
}
