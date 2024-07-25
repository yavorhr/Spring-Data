package com.example.mappingobjectslab.services.impl;
import com.example.mappingobjectslab.entity.dto.ManagerDto;
import com.example.mappingobjectslab.repositories.EmployeeRepository;
import com.example.mappingobjectslab.services.EmployeeService;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

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

  }


}
