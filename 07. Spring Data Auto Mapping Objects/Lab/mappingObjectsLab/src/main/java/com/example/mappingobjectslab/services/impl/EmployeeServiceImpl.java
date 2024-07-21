package com.example.mappingobjectslab.services.impl;

import com.example.mappingobjectslab.entity.dto.EmployeeDto;
import com.example.mappingobjectslab.entity.dto.ManagerDto;
import com.example.mappingobjectslab.entity.model.Employee;
import com.example.mappingobjectslab.repositories.EmployeeRepository;
import com.example.mappingobjectslab.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public EmployeeDto findEmployeeById(long id) {
    var employee = this.employeeRepository.findById(id).orElse(null);
    return new ModelMapper().map(employee, EmployeeDto.class);
  }

  @Override
  public ManagerDto findManagerById(long id) {
    var manager = this.employeeRepository.findById(id).orElse(null);
    return new ModelMapper().map(manager, ManagerDto.class);
  }

  @Override
  public List<EmployeeDto> findAllEmployeesBornBefore1990(LocalDate date) {
    List<Employee> employees = this.employeeRepository.findAllByBirthdayBefore(date);

    return new ModelMapper().map(employees, new TypeToken<List<EmployeeDto>>(){}.getType());
  }
}
