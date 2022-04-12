package com.example.finalproject.application.premiere;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class GetPremiereResponse {
    private String id;
    private String cinema_name;
    private ArrayList<PremiereResponseInfo> premiereResponseInfos;
}
