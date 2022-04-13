package com.example.finalproject.api;

import com.example.finalproject.application.seats.GetSeatParam;
import com.example.finalproject.application.seats.SeatData;
import com.example.finalproject.application.seats.SeatRows;
import com.example.finalproject.application.seats.SeatService;
import com.example.finalproject.core.seats.SeatOccupied;
import com.example.finalproject.core.seats.Seats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/seats")
public class SeatApi {

    @Autowired
    SeatService seatService;

    @GetMapping("")
    public ArrayList<SeatRows> getSeats(@RequestParam String room_id) {
        return seatService.get(room_id);
    }

    @GetMapping("/status")
    public ArrayList<SeatOccupied> getSeatsPremiere(@RequestParam String premiere_id) {
        return seatService.getSeatsPremiere(premiere_id);
    }
}
