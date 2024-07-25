package com.example.mappingobjectslab.services.impl;

import com.example.mappingobjectslab.entity.dto.RequestCreateManagerDto;
import com.example.mappingobjectslab.entity.dto.ManagerDto;
import com.example.mappingobjectslab.entity.dto.ResponseCreateManagerDto;
import com.example.mappingobjectslab.entity.model.Employee;
import com.example.mappingobjectslab.repositories.EmployeeRepository;
import com.example.mappingobjectslab.services.EmployeeService;
import org.modelmapper.ModelMapper;

import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;
  private final ModelMapper modelMapper;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
    this.employeeRepository = employeeRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public ManagerDto findManagerById(long id) {
    var manager = this.employeeRepository.findById(id).orElse(null);
    return this.modelMapper.map(manager, ManagerDto.class);
  }

  @Override
  public List<ManagerDto> findAll() {
    List<Employee> employees = this.employeeRepository.findAllByManagerIsNull();
    return this.modelMapper.map(employees, new TypeToken<List<ManagerDto>>() {
    }.getType());
  }

  @Override
  public ResponseCreateManagerDto save(RequestCreateManagerDto manager) {
    Employee employee = this.modelMapper.map(manager, Employee.class);
    employee.setBirthday(LocalDate.parse(manager.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    employee = this.employeeRepository.save(employee);

    return this.modelMapper.map(employee, ResponseCreateManagerDto.class);
  }
}
