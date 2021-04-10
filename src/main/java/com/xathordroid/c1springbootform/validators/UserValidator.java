package com.xathordroid.c1springbootform.validators;

import com.xathordroid.c1springbootform.models.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.user.lastName");

        if (!user.getIdentifier().matches("[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]")) {
            errors.rejectValue("identifier", "pattern.user.identifier");
        }
    }
}
