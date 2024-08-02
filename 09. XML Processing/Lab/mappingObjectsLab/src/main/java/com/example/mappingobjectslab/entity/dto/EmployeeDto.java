package com.example.mappingobjectslab.entity.dto;
import com.example.mappingobjectslab.entity.model.Employee;


import java.math.BigDecimal;

public class EmployeeDto extends BasicDto {

  private BigDecimal salary;
  private String manager;

  public EmployeeDto() {
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



}
