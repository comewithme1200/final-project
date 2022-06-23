package com.example.finalproject.application.price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceCreateParam {
    @NotNull
    private String name;
    private String detail;
    private long amount;
}
