package com.example.football.util.impl;

import com.example.football.util.ValidationUtil;
import org.springframework.stereotype.Component;

import javax.validation.Validator;
import javax.validation.Validation;

@Component
public class ValidationUtilImpl implements ValidationUtil {

    private final Validator validator;

    public ValidationUtilImpl() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }
}
