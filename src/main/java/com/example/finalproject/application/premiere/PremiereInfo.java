package com.example.finalproject.application.premiere;

import com.example.finalproject.core.premiere.Premiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PremiereInfo {
    private String id;
    private Timestamp startTime;
    private String movieId;
    private String roomId;

    public static PremiereInfo fromPremiere(Premiere premiere) {
        Timestamp start_timestamp = Timestamp.valueOf(premiere.getStart_time());
        return new PremiereInfo(
            premiere.getId(),
            start_timestamp,
            premiere.getMovie_id(),
            premiere.getRoom_id()
        );
    }
}
