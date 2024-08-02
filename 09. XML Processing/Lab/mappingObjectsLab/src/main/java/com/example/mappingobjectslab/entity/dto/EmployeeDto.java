package com.example.mappingobjectslab.entity.dto;
import com.example.mappingobjectslab.entity.model.Employee;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"firstName", "lastName", "salary"})
public class EmployeeDto extends BasicDto {

  @XmlAttribute
  private BigDecimal salary;
  @XmlAttribute
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
