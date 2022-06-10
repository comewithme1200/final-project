package com.example.finalproject.application.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceHistory {
    private String invoice_id;
    private String movie_name;
    private String image_path;
    private Date created_date;
    private Timestamp premiere_end_time;
    private int totalPrice;
}

