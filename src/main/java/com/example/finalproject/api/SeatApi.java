package com.example.finalproject.api;

import com.example.finalproject.api.exception.NotFoundException;
import com.example.finalproject.application.seats.SeatRows;
import com.example.finalproject.application.seats.SeatService;
import com.example.finalproject.core.seats.SeatOccupied;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatApi {

    @Autowired
    SeatService seatService;

    @GetMapping("/status")
    public List<SeatRows> getSeatsStatus(@RequestParam(required = true) String room_id, @RequestParam(required = true) String premiere_id) {
        return seatService.get(room_id, premiere_id);
    }

//    @GetMapping("/status")
//    public ArrayList<SeatOccupied> getSeatsPremiere(@RequestParam String premiere_id) {
//        return seatService.getSeatsPremiere(premiere_id);
//    }

    @PostMapping
    public List<SeatOccupied> insertSeatOccupied(@RequestBody List<SeatOccupied> seatOccupieds) throws NotFoundException {
        return seatService.insertSeatOccupied(seatOccupieds);
    }

    @PutMapping
    public String updateSeatOccupied(@RequestBody List<SeatOccupied> seatOccupieds) {
        return seatService.updateSeatOccupied(seatOccupieds);
    }
}
