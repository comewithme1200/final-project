package com.example.finalproject.core.rooms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Room {
    private String id;
    private String cinema_id;
    private String room_name;

    public Room(String cinema_id, String room_name) {
        this.id = UUID.randomUUID().toString();
        this.cinema_id = cinema_id;
        this.room_name = room_name;
    }
}
