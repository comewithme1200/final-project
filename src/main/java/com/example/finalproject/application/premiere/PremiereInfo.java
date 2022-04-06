package com.example.finalproject.application.premiere;

import com.example.finalproject.core.premiere.Premiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PremiereInfo {
    private String id;
    private Date startTime;
    private String roomId;

    public static PremiereInfo fromPremiere(Premiere premiere) {
        return new PremiereInfo(
            premiere.getId(),
            premiere.getStartTime(),
            premiere.getRoomId()
        );
    }
}
