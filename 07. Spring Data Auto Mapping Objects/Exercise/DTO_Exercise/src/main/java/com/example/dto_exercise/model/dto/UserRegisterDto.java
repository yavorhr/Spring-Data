package com.example.dto_exercise.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRegisterDto {
    private String email;
    private String password;
    private String confirmedPassword;
    private String fullName;

    public UserRegisterDto() {
    }

    public UserRegisterDto(String email, String password, String confirmedPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
        this.fullName = fullName;
    }

    @Email(message = "Enter valid email")
    public String getEmail() {
        return email;
    }

    @Pattern(regexp = "[A-Za-z\\d]{6,}", message = "Enter valid password")
    public String getPassword() {
        return password;
    }


    @Size(min = 2)
    public String getFullName() {
        return fullName;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }
}
