package com.example.mappingobjectslab.entity.dto;
import java.math.BigDecimal;

public class EmployeeDto extends BasicDto {
  private BigDecimal salary;
  
  public EmployeeDto() {
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }


}
