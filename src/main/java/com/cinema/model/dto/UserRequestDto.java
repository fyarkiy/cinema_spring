package com.cinema.model.dto;

import com.cinema.config.validations.EmailConstraint;
import com.cinema.config.validations.PasswordMatchConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatchConstraint(
        password = "password",
        repeatPassword = "repeatPassword",
        message = "Password and repeat password are not the same!"
)
public class UserRequestDto {
    @EmailConstraint
    private String email;
    @NotNull(message = "password can't be null")
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;
    @NotNull(message = "repeat password can't be null")
    @Size(min = 8, message = "password should have at least 8 characters")
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
