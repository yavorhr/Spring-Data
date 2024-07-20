package com.example.mappingobjectslab.entity.dto;

import com.example.mappingobjectslab.entity.model.Employee;

import java.util.List;

public class ManagerDto extends BasicDto {
  private List<Employee> subordinates;

  public ManagerDto() {
  }

  public List<Employee> getSubordinates() {
    return subordinates;
  }

  public void setSubordinates(List<Employee> subordinates) {
    this.subordinates = subordinates;
  }
}
