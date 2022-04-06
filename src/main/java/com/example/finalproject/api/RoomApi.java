package com.example.finalproject.api;

import com.example.finalproject.application.room.RoomCreateParam;
import com.example.finalproject.application.room.RoomInfo;
import com.example.finalproject.application.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomApi {

    @Autowired
    public RoomService roomService;

    @PostMapping(path = "/create")
    public RoomInfo create(@RequestBody RoomCreateParam roomCreateParam) {
        return roomService.create(roomCreateParam);
    }
}
