package com.example.finalproject.application.premiere;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetPremiereResponse {
    private String cinema_name;
    private ArrayList<PremiereResponseInfo> premiereResponseInfos;
}
