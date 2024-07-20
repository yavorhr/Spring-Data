package com.example.mappingobjectslab.services;

import com.example.mappingobjectslab.entity.dto.EmployeeDto;
import com.example.mappingobjectslab.entity.dto.ManagerDto;

public interface EmployeeService {

  EmployeeDto findEmployeeById(long id);

  ManagerDto findManagerById(long id);

}
