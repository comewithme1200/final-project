package com.example.finalproject.application.premiere;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PremiereCreateParam {
    private Date start_time;
    private Date end_time;
    @NotBlank(message = "can not be empty")
    private String movie_id;
    @NotBlank(message = "can not be empty")
    private String room_id;
}
