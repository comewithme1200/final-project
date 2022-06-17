package com.example.finalproject.application.movies;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = DuplicatedMovieNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface DuplicatedMovieNameConstraint {
    String message() default "duplicated movie name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
