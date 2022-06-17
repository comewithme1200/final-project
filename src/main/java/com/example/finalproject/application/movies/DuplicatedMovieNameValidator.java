package com.example.finalproject.application.movies;

import com.example.finalproject.core.movies.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DuplicatedMovieNameValidator implements ConstraintValidator<DuplicatedMovieNameConstraint, String> {

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (value == null || value.isEmpty()) || !moviesRepository.findByName(value).isPresent();
    }

}
