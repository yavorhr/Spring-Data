package com.example.nextleveltech.service.impl;

import com.example.nextleveltech.repositoriy.EmployeeRepository;
import com.example.nextleveltech.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public boolean areFilesImported() {
    return employeeRepository.existsAllBy();
  }
}
