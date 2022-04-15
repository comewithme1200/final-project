package com.example.finalproject.application.premiere;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PremiereResponseInfo {
    private String room_id;
    private String room_name;
    private List<PremiereDto> premiereDtos;
}
