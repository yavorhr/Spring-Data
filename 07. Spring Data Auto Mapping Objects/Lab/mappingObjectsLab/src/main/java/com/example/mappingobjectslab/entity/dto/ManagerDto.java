package com.example.mappingobjectslab.entity.dto;

import com.example.mappingobjectslab.entity.model.Employee;

import java.util.List;

public class ManagerDto extends BasicDto {
  private List<EmployeeDto> subordinates;

  public ManagerDto() {
  }

  public List<EmployeeDto> getSubordinates() {
    return this.subordinates;
  }

  public void setSubordinates(List<EmployeeDto> subordinates) {
    this.subordinates = subordinates;
  }
}
