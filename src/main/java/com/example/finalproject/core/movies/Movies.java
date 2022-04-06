package com.example.finalproject.core.movies;

import com.example.finalproject.application.movies.MovieCreateParam;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class Movies {
    private String id;
    private String movie_name;
    private Date premiere_date;
    private String detail;
    private String trailer_link;
    private String image_path;

    public Movies(String movie_name, Date premiere_date, String detail, String trailer_link, String image_path) {
        this.id = UUID.randomUUID().toString();
        this.movie_name = movie_name;
        this.premiere_date = premiere_date;
        this.detail = detail;
        this.trailer_link = trailer_link;
        this.image_path = image_path;
    }

}
