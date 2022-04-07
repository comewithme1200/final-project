package com.example.finalproject.core.premiere;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Premiere {
    private String id;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private String movie_id;
    private String room_id;

    public Premiere(LocalDateTime start_time, LocalDateTime end_time, String movie_id, String room_id) {
        this.id = UUID.randomUUID().toString();
        this.start_time = start_time;
        this.end_time = end_time;
        this.movie_id = movie_id;
        this.room_id = room_id;
    }

}
