package com.dev.insure.validator;

import com.dev.insure.model.Agreement;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AgreementFormValidator implements Validator {



    @Override
    public boolean supports(Class<?> aClass) {
        return Agreement.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Agreement agreement = (Agreement) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "NotEmpty");
    }
}
