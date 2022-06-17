package com.example.finalproject.application.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieCreateParam {
    @DuplicatedMovieNameConstraint
    @NotBlank(message = "Movie name can not be empty")
    private String movie_name;
    private Date premiere_date;
    @NotBlank(message = "detail can not be empty")
    private String detail;
    private String trailer_link;
    private String image_path;
    private int time;
}
