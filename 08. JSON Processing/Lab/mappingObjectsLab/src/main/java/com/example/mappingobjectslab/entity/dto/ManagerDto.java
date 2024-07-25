package com.example.mappingobjectslab.entity.dto;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.List;

public class ManagerDto extends BasicDto {
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private BigDecimal salary;
  @Expose
  private List<EmployeeDto> subordinates;

  public ManagerDto() {
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public List<EmployeeDto> getSubordinates() {
    return this.subordinates;
  }

  public void setSubordinates(List<EmployeeDto> subordinates) {
    this.subordinates = subordinates;
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  @Override
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
