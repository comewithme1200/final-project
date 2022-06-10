package com.example.finalproject.application.room;

import com.example.finalproject.core.rooms.Room;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RoomInfo {
    private String id;
    private String room_name;
    private String cinema_id;
    private String room_type;

    public RoomInfo(String id, String room_name) {
        this.id = id;
        this.room_name = room_name;
    }

    public static RoomInfo fromRoom(Room room) {
        return new RoomInfo(
                room.getId(),
                room.getRoom_name()
        );
    }
}
