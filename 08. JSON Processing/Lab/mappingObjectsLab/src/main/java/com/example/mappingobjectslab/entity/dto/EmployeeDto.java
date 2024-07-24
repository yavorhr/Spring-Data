package com.example.mappingobjectslab.entity.dto;
import com.example.mappingobjectslab.entity.model.Employee;

import java.math.BigDecimal;

public class EmployeeDto extends BasicDto {
  private BigDecimal salary;
  private Employee manager;

  public EmployeeDto() {
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public Employee getManager() {
    return manager;
  }

  public void setManager(Employee manager) {
    this.manager = manager;
  }
}
