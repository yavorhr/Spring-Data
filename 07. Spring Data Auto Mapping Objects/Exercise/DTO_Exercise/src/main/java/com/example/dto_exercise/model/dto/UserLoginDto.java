package com.example.dto_exercise.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class UserLoginDto {
  private String email;
  private String password;

  public UserLoginDto(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public UserLoginDto() {
  }

  @Email(message = "Please enter valid email!")
  public String getEmail() {
    return email;
  }

  @Pattern(regexp = "[A-Za-z\\d]{6,}", message = "PLease enter valid password!")
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
