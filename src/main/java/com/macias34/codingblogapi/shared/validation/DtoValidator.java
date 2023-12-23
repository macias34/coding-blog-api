package com.macias34.codingblogapi.shared.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import com.macias34.codingblogapi.shared.exception.BadRequestException;

public class DtoValidator {
    public static <T> void validate(T entity) {
        Locale.setDefault(Locale.ENGLISH);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(entity);
        if (!violations.isEmpty()) {
            System.out.println(violations);
            String errors = violations.stream()
                    .map(e -> String.format("%s: %s", e.getPropertyPath(), e.getMessage()))
                    .collect(Collectors.joining(", "));
            throw new BadRequestException(errors);
        }
    }

}