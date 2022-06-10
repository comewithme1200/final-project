package com.example.finalproject.application.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomCreateParam {
    private String cinema_id;
    private String room_name;
    private String room_type;
}
