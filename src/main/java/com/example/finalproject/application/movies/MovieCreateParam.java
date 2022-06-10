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
    @NotBlank(message = "Movie name can not be empty")
    private String movie_name;
    @NotBlank(message = "premiere date can not be empty")
    private Date premiere_date;
    @NotBlank(message = "detail can not be empty")
    private String detail;
    private String trailer_link;
    private String image_path;
    @NotBlank(message = "time can not be empty")
    private int time;
}
