package com.example.mappingobjectslab.entity.dto;



import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.util.List;

@XmlRootElement
public class ManagerDto extends BasicDto { ;

  private BigDecimal salary;
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


}
