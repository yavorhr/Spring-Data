package com.example.mappingobjectslab.entity.dto;

import java.math.BigDecimal;

public class EmployeeDto {
  private String firstName;
  private String lastName;
  private BigDecimal salary;

  public EmployeeDto() {
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }
}
