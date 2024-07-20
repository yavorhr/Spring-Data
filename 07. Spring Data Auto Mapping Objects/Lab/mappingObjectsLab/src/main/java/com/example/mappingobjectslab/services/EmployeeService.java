package com.example.mappingobjectslab.services;

import com.example.mappingobjectslab.entity.dto.EmployeeDto;

public interface EmployeeService {

  EmployeeDto findEmployeeById(long id);
}
