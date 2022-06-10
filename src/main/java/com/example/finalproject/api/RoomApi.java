package com.example.finalproject.api;

import com.example.finalproject.application.room.RoomCreateParam;
import com.example.finalproject.application.room.RoomInfo;
import com.example.finalproject.application.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomApi {

    @Autowired
    public RoomService roomService;

    @PostMapping(path = "/create")
    public RoomInfo create(@RequestBody RoomCreateParam roomCreateParam) {
        return roomService.create(roomCreateParam);
    }

    @GetMapping
    public List<RoomInfo> getAllRooms() {
        return roomService.getAll();
    }
}
