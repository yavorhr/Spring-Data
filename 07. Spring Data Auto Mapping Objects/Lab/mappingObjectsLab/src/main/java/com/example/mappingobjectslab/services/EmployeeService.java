package com.example.mappingobjectslab.services;

import com.example.mappingobjectslab.entity.dto.EmployeeDto;
import com.example.mappingobjectslab.entity.dto.ManagerDto;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {

  EmployeeDto findEmployeeById(long id);

  ManagerDto findManagerById(long id);

  List<EmployeeDto> findAllEmployeesBornBefore1990(LocalDate of);
}
