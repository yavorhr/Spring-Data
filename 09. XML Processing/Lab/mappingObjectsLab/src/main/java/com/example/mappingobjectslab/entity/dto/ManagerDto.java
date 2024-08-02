package com.example.mappingobjectslab.entity.dto;

import jakarta.xml.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "manager")
@XmlAccessorType(XmlAccessType.FIELD)
public class ManagerDto extends BasicDto { ;

  private BigDecimal salary;

  @XmlElementWrapper(name = "subordinates")
  @XmlElement(name = "employee")
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
