package com.example.finalproject.application.movies;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@Data
public class MovieCreateParam {
    @NotBlank(message = "Movie name can not be empty")
    private String movie_name;
    private Date premiere_date;
    @NotBlank(message = "detail can not be empty")
    private String detail;
    private String trailer_link;
    private String image_path;

}
