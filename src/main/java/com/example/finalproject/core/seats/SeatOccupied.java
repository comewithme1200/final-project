package com.example.finalproject.core.seats;

import lombok.Data;

@Data
public class SeatOccupied {
    private String seat_id;
    private String premiere_id;
    private Integer status;
    private boolean disabled;
}
