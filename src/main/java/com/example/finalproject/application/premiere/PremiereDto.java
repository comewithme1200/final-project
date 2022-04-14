package com.example.finalproject.application.premiere;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PremiereDto {
    private String id;
    private ArrayList<String> start_times;
}
