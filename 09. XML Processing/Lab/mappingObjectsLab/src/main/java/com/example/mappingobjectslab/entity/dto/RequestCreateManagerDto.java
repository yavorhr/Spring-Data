package com.example.mappingobjectslab.entity.dto;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RequestCreateManagerDto {

  private String firstName;
  private String lastName;
  private BigDecimal salary;
  private String birthday;
  private String address;
  private boolean isOnHoliday;

  public RequestCreateManagerDto() {
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
