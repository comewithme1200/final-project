package com.example.finalproject.core.rooms;

import com.example.finalproject.application.room.RoomInfo;

import java.util.List;

public interface RoomRepository {
    void save(Room room);

    List<RoomInfo> getAll();

    RoomInfo findRoomById(String id);
}
