package com.example.finalproject.core.premiere;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Premiere {
    private String id;
    private Date startTime;
    private Date endTime;
    private String movieId;
    private String roomId;

    public Premiere(Date startTime, Date endTime, String movieId, String roomId) {
        this.id = UUID.randomUUID().toString();
        this.startTime = startTime;
        this.endTime = endTime;
        this.movieId = movieId;
        this.roomId = roomId;
    }

}
