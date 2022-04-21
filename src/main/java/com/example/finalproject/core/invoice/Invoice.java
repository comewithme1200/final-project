package com.example.finalproject.core.invoice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Invoice {
    private String id;
    private int status;
    private String user_id;

    public Invoice(int status, String user_id) {
        this.id = UUID.randomUUID().toString();
        this.status = status;
        this.user_id = user_id;
    }
}
