package com.example.finalproject.application.price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetResponse {
    private long standardPrice;
    private long vipPrice;
}
