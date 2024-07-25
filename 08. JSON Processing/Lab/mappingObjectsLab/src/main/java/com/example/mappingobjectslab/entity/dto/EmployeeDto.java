package com.example.mappingobjectslab.entity.dto;
import com.example.mappingobjectslab.entity.model.Employee;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class EmployeeDto extends BasicDto {
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private BigDecimal salary;
  @Expose
  private String manager;

  public EmployeeDto() {
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public String getManager() {
    return this.manager;
  }

  public void setManager(Employee manager) {
    this.manager = manager.getFirstName();
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
