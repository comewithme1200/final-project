package com.example.finalproject.application.cinemas;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaCreateParam {
    @NotBlank(message = "can not be empty")
    private String cinema_name;
    
    @NotBlank(message = "can not be empty")
    private String cinema_address;

}
