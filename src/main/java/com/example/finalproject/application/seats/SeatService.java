package com.example.finalproject.application.seats;

import com.example.finalproject.core.seats.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

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
}
