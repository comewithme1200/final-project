package com.example.finalproject.application.seats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatLeftResponse {
    private int vip_left;
    private int standard_left;
}
