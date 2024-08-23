package com.example.nextleveltech.web.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRegisterDto {
  private String username;
  private String password;
  private String confirmPassword;
  private String email;

  @NotBlank
  public String getUsername() {
    return username;
  }

  @NotBlank
  public String getPassword() {
    return password;
  }

  @NotBlank
  public String getConfirmPassword() {
    return confirmPassword;
  }

  @Email
  @NotBlank
  public String getEmail() {
    return email;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
