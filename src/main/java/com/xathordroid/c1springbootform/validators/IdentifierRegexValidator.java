package com.xathordroid.c1springbootform.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentifierRegexValidator implements ConstraintValidator<IdentifierRegex, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]");
    }
}
