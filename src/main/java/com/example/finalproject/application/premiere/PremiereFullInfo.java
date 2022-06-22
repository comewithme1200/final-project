package com.example.finalproject.application.premiere;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PremiereFullInfo {
    private String id;
    private Date start_time;
    private Date end_time;
    private String movie_name;
    private String room_name;
    private String room_id;
    private String movie_id;
    private String cinema_name;
    private String disabled;
}
