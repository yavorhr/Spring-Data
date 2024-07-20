package com.example.mappingobjectslab.services.impl;

import com.example.mappingobjectslab.entity.dto.EmployeeDto;
import com.example.mappingobjectslab.repositories.EmployeeRepository;
import com.example.mappingobjectslab.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public EmployeeDto findEmployeeById(long id) {
    var employee = this.employeeRepository.findById(id);

    return new ModelMapper().map(employee, EmployeeDto.class);
  }
}
