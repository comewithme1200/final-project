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
    private String cinema_name;

    public RoomInfo(String id, String room_name) {
        this.id = id;
        this.room_name = room_name;
    }

    public RoomInfo(String id, String room_name, String cinema_id, String room_type) {
        this.id = id;
        this.room_name = room_name;
        this.cinema_id = cinema_id;
        this.room_type = room_type;
    }


    public static RoomInfo fromRoom(Room room) {
        return new RoomInfo(
                room.getId(),
                room.getRoom_name()
        );
    }
}
