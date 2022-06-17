package com.example.finalproject.application.invoiceDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketInfo {
    private String cinema;
    private String movie_name;
    private Date start_time;
    private String room_name;
    private String seat;
}
