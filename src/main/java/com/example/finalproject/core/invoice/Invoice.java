package com.example.finalproject.core.invoice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Invoice {
    private String id;
    private int status;
    private String user_id;
    private Date created_date;

    public Invoice(int status, String user_id, Date created_date) {
        this.id = UUID.randomUUID().toString();
        this.status = status;
        this.user_id = user_id;
        this.created_date = created_date;
    }
}
