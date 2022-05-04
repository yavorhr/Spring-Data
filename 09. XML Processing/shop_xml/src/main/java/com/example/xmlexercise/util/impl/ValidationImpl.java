package com.example.xmlexercise.util.impl;

import com.example.xmlexercise.util.ValidationUtil;
import org.springframework.stereotype.Component;
import javax.validation.Validator;
import javax.validation.Validation;

@Component
public class ValidationImpl implements ValidationUtil {

    private final Validator validator;
    public ValidationImpl() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }
}
