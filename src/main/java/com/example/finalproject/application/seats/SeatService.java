package com.example.finalproject.application.seats;

import com.example.finalproject.api.exception.NotFoundException;
import com.example.finalproject.core.seats.SeatOccupied;
import com.example.finalproject.core.seats.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SeatService {

    @Autowired
    SeatsRepository seatsRepository;

    public ArrayList<SeatRows> get(String RoomId) {
        ArrayList<SeatData> seatDataArrayList = seatsRepository.getSeat(RoomId);
        ArrayList<SeatRow> seatRowArrayList = seatsRepository.getSeatRow(RoomId);
        ArrayList<SeatRows> seatRowsArrayList = new ArrayList<SeatRows>();
        for (SeatRow seatRow : seatRowArrayList) {
            ArrayList<SeatNumber> seatNumberArrayList = new ArrayList<SeatNumber>();
            for (SeatData seatData : seatDataArrayList) {
                if (Objects.equals(seatData.getRows_alphabet(), seatRow.getRows_alphabet())) {
                    seatNumberArrayList.add(new SeatNumber(seatData.getId(), seatData.getNumber()));
                }
            }
            seatRowsArrayList.add(new SeatRows(seatRow.getRows_alphabet(), seatNumberArrayList));
        }

        return seatRowsArrayList;
    }

    public ArrayList<SeatOccupied> getSeatsPremiere(String premiere_id) {
        return seatsRepository.getSeatsPremiere(premiere_id);
    }

    public List<SeatOccupied> insertSeatOccupied(List<SeatOccupied> seatOccupieds) throws NotFoundException {
        List<SeatOccupied> result = seatOccupieds.stream().filter(item -> !seatsRepository.existsSeatOccupied(item.getSeat_id(), item.getPremiere_id())).distinct().collect(Collectors.toList());
        if (result.size() == 0) {
            throw new NotFoundException("seat occupied exists");
        }
        seatsRepository.insertSeatOccupied(result);
        return result;
    }
}
