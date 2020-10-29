package com.cinema.config.validations;

import com.cinema.model.dto.UserRequestDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordMatchValidator
        implements ConstraintValidator<PasswordMatchConstraint, UserRequestDto> {
    private String password;
    private String repeatPassword;

    public void initialize(PasswordMatchConstraint constraint) {
        this.password = constraint.password();
        this.repeatPassword = constraint.repeatPassword();
    }

    public boolean isValid(UserRequestDto userRequestDto, ConstraintValidatorContext context) {

        String passwordValue = (String) new BeanWrapperImpl(userRequestDto)
                .getPropertyValue(password);
        String repeatPasswordValue = (String) new BeanWrapperImpl(userRequestDto)
                .getPropertyValue(repeatPassword);

        if (passwordValue != null) {
            return passwordValue.equals(repeatPasswordValue);
        } else {
            return passwordValue == null;
        }
    }
}
