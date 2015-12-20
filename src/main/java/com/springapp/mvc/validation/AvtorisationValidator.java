package com.springapp.mvc.validation;

import com.springapp.mvc.domain.Avtorisation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Yurii on 16.10.2015.
 */

@Component
public class AvtorisationValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return Avtorisation.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object model, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "required.login", "Введіть логін.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "required.pass", "Введіть пароль.");
    }
}
