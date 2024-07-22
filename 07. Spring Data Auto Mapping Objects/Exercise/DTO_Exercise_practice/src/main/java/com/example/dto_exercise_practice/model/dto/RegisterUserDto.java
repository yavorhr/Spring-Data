package com.example.dto_exercise_practice.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class RegisterUserDto {
  private String email;
  private String password;
  private String confirmPassword;
  private String fullName;

  public RegisterUserDto() {
  }

  public RegisterUserDto(String email, String password, String confirmPassword, String fullName) {
    this.email = email;
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.fullName = fullName;
  }

  public String getFullName() {
    return fullName;
  }

  public RegisterUserDto(String email, String password, String confirmPassword) {
    this.email = email;
    this.password = password;
    this.confirmPassword = confirmPassword;
  }

  @Email(message = "PLease enter valid email!")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Pattern(regexp = "[A-Za-z\\d]{6,}", message = "PLease enter valid password!")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
}
