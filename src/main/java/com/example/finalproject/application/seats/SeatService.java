package com.example.finalproject.application.seats;

import com.example.finalproject.api.exception.NotFoundException;
import com.example.finalproject.application.room.RoomInfo;
import com.example.finalproject.core.rooms.RoomRepository;
import com.example.finalproject.core.seats.SeatOccupied;
import com.example.finalproject.core.seats.Seats;
import com.example.finalproject.core.seats.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {

    @Autowired
    SeatsRepository seatsRepository;

    @Autowired
    RoomRepository roomRepository;

    public List<SeatRows> get(String roomId, String premiereId) {
        return seatsRepository.getSeatsStatus(roomId, premiereId);
    }

    public ArrayList<SeatOccupied> getSeatsPremiere(String premiere_id) {
        return seatsRepository.getSeatsPremiere(premiere_id);
    }

    public Seats getSeatNameById(String seat_id) {
        Seats seat = seatsRepository.getSeatNameById(seat_id);
        return seat;
    }

    public List<SeatOccupied> insertSeatOccupied(List<SeatOccupied> seatOccupieds) throws NotFoundException {
        List<SeatOccupied> result = seatOccupieds.stream().filter(item -> !seatsRepository.existsSeatOccupied(item.getSeat_id(), item.getPremiere_id())).distinct().collect(Collectors.toList());
        if (result.size() == 0) {
            throw new NotFoundException("Rất xin lỗi! Trong lúc quý khách chọn ghế tất cả vị trí được chọn đã được người khác process");
        } else if (result.size() < seatOccupieds.size()) {
            List<SeatOccupied> occupiedsList = seatOccupieds.stream().filter(item -> seatsRepository.existsSeatOccupied(item.getSeat_id(), item.getPremiere_id())).distinct().collect(Collectors.toList());
            List<String> seatName = new ArrayList<>();
            for (SeatOccupied seatOccupied : occupiedsList) {
                Seats seat = getSeatNameById(seatOccupied.getSeat_id());
                seatName.add(seat.getRows_alphabet() + seat.getNumber());
            }
            throw new NotFoundException(String.format("Rất xin lỗi! rong lúc quý khách chọn ghế các ghế %s đã được chọn", String.join(", ", seatName)));
        }
        seatsRepository.insertSeatOccupied(result);
        return result;
    }

    public String updateSeatOccupied(List<SeatOccupied> seatOccupieds) {
        seatsRepository.update(seatOccupieds);
        return "Success";
    }
    public String  deleteSeatOccupied(List<SeatOccupied> seatOccupieds) {
        seatsRepository.delete(seatOccupieds);
        return "Success";
    }

    public SeatLeftResponse getNumberSeatNotOccupied(String room_id, String premiere_id) {
        List<Integer> numberOfSeatOccupied = seatsRepository.getNumberOfSeatOccupied(premiere_id);
        RoomInfo room = roomRepository.findRoomById(room_id);
        if (numberOfSeatOccupied.isEmpty()) {
            if (room.getRoom_type().equals("Golden")) {
                return new SeatLeftResponse(20, 44);
            }
            return new SeatLeftResponse(44, 76);
        }
        int vip_left = 0;
        int standard_left = 0;
        if (room.getRoom_type().equals("Golden")) {
            standard_left = Math.max(44 - numberOfSeatOccupied.get(0), 0);
            vip_left = Math.max(20 - numberOfSeatOccupied.get(1), 0);
        } else {
            standard_left = Math.max(76 - numberOfSeatOccupied.get(0), 0);
            vip_left = Math.max(44 - numberOfSeatOccupied.get(1), 0);
        }
        return new SeatLeftResponse(vip_left, standard_left);
    }

}
