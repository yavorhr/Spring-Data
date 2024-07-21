package com.example.dtoex.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserLoginDto {

    private String email;
    private String password;


    @Email(message = "Enter valid email")
    public String getEmail() {
        return email;
    }

    public UserLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserLoginDto() {
    }

    @Pattern(regexp = "[A-Za-z\\d]{6,}", message = "Enter valid password")
    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
