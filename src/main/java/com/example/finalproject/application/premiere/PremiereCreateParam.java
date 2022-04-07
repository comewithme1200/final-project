package com.example.finalproject.application.premiere;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PremiereCreateParam {
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    @NotBlank(message = "can not be empty")
    private String movie_id;
    @NotBlank(message = "can not be empty")
    private String room_id;
}
