package com.intellibucket.ws.validation.concretes;

import com.intellibucket.ws.validation.annotation.Interval;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class IntervalValidator implements ConstraintValidator<Interval, Integer> {
    private int min;
    private int max;

    @Override
    public void initialize(Interval constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return Optional.ofNullable(value)
                .map(v -> v >= min && v <= max)
                .orElse(true);
    }
}
