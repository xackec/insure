package com.dev.insure.validator;

import com.dev.insure.model.Agreement;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Calendar;
import java.util.regex.Pattern;

@Component
public class AgreementFormValidator implements Validator {

    private static final Pattern AMOUNT_REGEX = Pattern.compile("^[1-9]\\d*$");
    private static final Pattern SQUARE_REGEX = Pattern.compile("(^\\d{1,4}$)|(^\\d{0,4}[.]\\d{1,1}$)");
    private static final Pattern FEE_REGEX = Pattern.compile("(^\\d+$)|(\\d+\\.\\d{1,2}$)");
    private static final Pattern NUM_REGEX = Pattern.compile("^\\d{1,6}$");

    @Override
    public boolean supports(Class<?> aClass) {
        return Agreement.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Agreement agreement = (Agreement) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "num", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "validFrom", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "validTo", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject.square", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fee", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "num", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject.state", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject.region", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject.city", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject.street", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject.flatnum", "NotEmpty");

        if(agreement.getNum()!=null && !NUM_REGEX.matcher(agreement.getNum()).matches()) {
            errors.rejectValue("num", "Invalid");
        }

        if(agreement.getFee()!=null && !FEE_REGEX.matcher(agreement.getFee()).matches()) {
            errors.rejectValue("fee", "Invalid");
        }

        Calendar cal = Calendar.getInstance();
        cal.roll(Calendar.DATE, -1);

        if(agreement.getValidFrom()!=null && agreement.getValidTo()!=null) {
            if(agreement.getValidFrom().before(cal.getTime())) {
                errors.rejectValue("validFrom", "Invalid");
            }

            if(agreement.getValidTo().before(agreement.getValidFrom()) ||
                    (agreement.getValidTo().getTime()-agreement.getValidFrom().getTime()) > 31536000000L) {
                errors.rejectValue("validTo", "Invalid");
            }
        }

        if(agreement.getAmount()!=null && !AMOUNT_REGEX.matcher(agreement.getAmount()).matches()) {
            errors.rejectValue("amount", "Invalid");
        }

        if(agreement.getSubject().getSquare()!= null && !SQUARE_REGEX.matcher(agreement.getSubject().getSquare()).matches()) {
            errors.rejectValue("subject.square", "Invalid");
        }
    }
}
