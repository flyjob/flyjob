package com.intellibucket.ws.validation.annotation;

import com.intellibucket.ws.validation.concretes.IntervalValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IntervalValidator.class)
@Target( { ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Interval {
    String message() default "F0000000010";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int min() default Integer.MIN_VALUE;
    int max() default Integer.MAX_VALUE;
}
