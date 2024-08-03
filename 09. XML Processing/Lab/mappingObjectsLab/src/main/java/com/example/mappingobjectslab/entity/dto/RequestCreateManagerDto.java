package com.example.mappingobjectslab.entity.dto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;

@XmlRootElement(name = "manager")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestCreateManagerDto {

  @XmlElement
  private String firstName;
  @XmlElement
  private String lastName;
  @XmlElement
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
