package com.liucheyu.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liucheyu
 */
public class StatusValuesConstraintValidator implements ConstraintValidator<StatusValues, Integer> {

    Set<Integer> validSet = new HashSet<>(2);

    @Override
    public void initialize(StatusValues constraintAnnotation) {
        for (int value : constraintAnnotation.values()) {
            validSet.add(value);
        }
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return validSet.contains(integer);
    }
}
