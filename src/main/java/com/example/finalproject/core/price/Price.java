package com.example.finalproject.core.price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private String id;
    private String name;
    private String detail;
    private long amount;

    public Price(String name, String detail, long amount) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.detail = detail;
        this.amount = amount;
    }
}
