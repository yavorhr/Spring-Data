package com.example.mappingobjectslab.entity.dto;

import com.example.mappingobjectslab.entity.model.Employee;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;

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
