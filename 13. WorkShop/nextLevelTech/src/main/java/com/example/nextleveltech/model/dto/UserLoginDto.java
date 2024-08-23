package com.example.nextleveltech.model.dto;

import jakarta.validation.constraints.NotBlank;

public class UserLoginDto {
  private String username;
  private String password;

  @NotBlank
  public String getUsername() {
    return username;
  }

  @NotBlank
  public String getPassword() {
    return password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
