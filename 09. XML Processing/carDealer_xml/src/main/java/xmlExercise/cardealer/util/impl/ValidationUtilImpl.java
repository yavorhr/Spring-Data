package xmlExercise.cardealer.util.impl;
import xmlExercise.cardealer.util.ValidationUtil;

import javax.validation.Validation;
import org.springframework.stereotype.Component;
import javax.validation.Validator;


@Component
public class ValidationUtilImpl implements ValidationUtil {
    private  final Validator validator;

    public ValidationUtilImpl(Validator validator) {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }
}
