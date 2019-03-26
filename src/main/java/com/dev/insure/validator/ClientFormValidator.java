package com.dev.insure.validator;

import com.dev.insure.model.Client;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class ClientFormValidator implements Validator {

    private final Pattern DIGITS_REGEX = Pattern.compile("^(0|[1-9][0-9]*)$");
    private final Pattern LETTERS_REGEX = Pattern.compile("^[а-яА-Яa-zA-Z0-9.\\-\\/+=@_ ]*$");

    @Override
    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Client client = (Client) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthDate", "NotEmpty");


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passportS", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passportN", "NotEmpty");

        if(client.getFullName()!=null && !LETTERS_REGEX.matcher(client.getFullName()).matches()) {
            errors.rejectValue("fullName", "Invalid");
        }

        if(client.getPassportS()!=null && !DIGITS_REGEX.matcher(client.getPassportS()).matches()) {
            errors.rejectValue("passportS", "Invalid");
        }

        if(client.getPassportN()!=null && !DIGITS_REGEX.matcher(client.getPassportN()).matches()) {
            errors.rejectValue("passportN", "Invalid");
        }
    }
}
