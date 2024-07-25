package com.example.mappingobjectslab.entity.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CreateManagerDto {
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private BigDecimal salary;
  @Expose
  private List<EmployeeDto> subordinates;employees
  @Expose
  private String birthday;
  @Expose
  private String address;
  @Expose
  private boolean isOnHoliday;

  public CreateManagerDto() {
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

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public List<EmployeeDto> getSubordinates() {
    return subordinates;
  }

  public void setSubordinates(List<EmployeeDto> subordinates) {
    this.subordinates = subordinates;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public boolean isOnHoliday() {
    return isOnHoliday;
  }

  public void setOnHoliday(boolean onHoliday) {
    isOnHoliday = onHoliday;
  }
}
