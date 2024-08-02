package com.example.mappingobjectslab.entity.dto;

import com.google.gson.annotations.Expose;

public class BasicDto {
  @Expose
  private String firstName;
  @Expose
  private String lastName;

  public BasicDto() {
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
