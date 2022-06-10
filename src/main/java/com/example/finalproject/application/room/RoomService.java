package com.example.finalproject.application.room;

import com.example.finalproject.core.rooms.Room;
import com.example.finalproject.core.rooms.RoomRepository;
import com.example.finalproject.core.seats.Seats;
import com.example.finalproject.core.seats.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    SeatsRepository seatsRepository;

    private final static String STANDARD = "standard";

    private final static String VIP = "vip";

    public RoomInfo create(RoomCreateParam roomCreateParam) {
        Room room = new Room(roomCreateParam.getCinema_id(), roomCreateParam.getRoom_name(), roomCreateParam.getRoom_type());
        roomRepository.save(room);
        ArrayList<Seats> seatsArrayList = new ArrayList<>();
        if (Objects.equals(roomCreateParam.getRoom_type(), "2D")) {
            char ch;
            for (ch = 'A'; ch <= 'H'; ch++) {
                for (int i = 0; i < 15; i++) {
                    if (ch > 'B' && ch < 'G') {
                        Seats seat;
                        if (i > 1 && i < 13) {
                            seat = new Seats(i + 1, Character.toString(ch), room.getId(), VIP);
                        } else {
                            seat = new Seats(i + 1, Character.toString(ch), room.getId(), STANDARD);
                        }
                        seatsArrayList.add(seat);
                    } else {
                        Seats seats = new Seats(i + 1, Character.toString(ch), room.getId(), STANDARD);
                        seatsArrayList.add(seats);
                    }
                }
            }
        } else {
            char ch;
            for (ch = 'A'; ch <= 'H'; ch++) {
                for (int i = 0; i < 8; i++) {
                    if (ch > 'B' && ch < 'G') {
                        Seats seat;
                        if (i > 1 && i < 6) {
                            seat = new Seats(i + 1, Character.toString(ch), room.getId(), VIP);
                        } else {
                            seat = new Seats(i + 1, Character.toString(ch), room.getId(), STANDARD);
                        }
                        seatsArrayList.add(seat);
                    } else {
                        Seats seats = new Seats(i + 1, Character.toString(ch), room.getId(), STANDARD);
                        seatsArrayList.add(seats);
                    }
                }
            }
        }
        seatsRepository.autoRenderSeats(seatsArrayList);

        return RoomInfo.fromRoom(room);
    }

    public List<RoomInfo> getAll() {
        return roomRepository.getAll();
    }

}
