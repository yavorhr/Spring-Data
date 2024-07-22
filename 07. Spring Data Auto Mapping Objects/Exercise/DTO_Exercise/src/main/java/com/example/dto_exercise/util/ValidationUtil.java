package com.example.dto_exercise.util;


import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidationUtil {

    <E> Set<ConstraintViolation<E>> violation(E entity);

    <E> boolean isValid(E entity);
}
