package com.example.finalproject.application.room;

import com.example.finalproject.core.rooms.Room;
import com.example.finalproject.core.rooms.RoomRepository;
import com.example.finalproject.core.seats.Seats;
import com.example.finalproject.core.seats.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    SeatsRepository seatsRepository;

    public RoomInfo create(RoomCreateParam roomCreateParam) {
        Room room = new Room(roomCreateParam.getCinema_id(), roomCreateParam.getRoom_name());
        roomRepository.save(room);
        ArrayList<Seats> seatsArrayList = new ArrayList<>();
        if (Objects.equals(roomCreateParam.getRoom_name(), "Rạp 2D")) {
            char ch;
            for( ch = 'A' ; ch <= 'H' ; ch++ ) {
                for (int i = 0; i < 15; i++) {
                    Seats seat = new Seats(i+1, Character.toString(ch), room.getId());
                    seatsArrayList.add(seat);
                }
            }
            seatsRepository.autoRenderSeats(seatsArrayList);
        } else {
            char ch;
            for( ch = 'A' ; ch <= 'H' ; ch++ ) {
                for (int i = 0; i < 8; i++) {
                    Seats seat = new Seats(i+1, Character.toString(ch), room.getId());
                    seatsArrayList.add(seat);
                }
            }
            seatsRepository.autoRenderSeats(seatsArrayList);
        }

        return RoomInfo.fromRoom(room);
    }

}
