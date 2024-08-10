package com.example.mappingobjectslab.services;

import com.example.mappingobjectslab.entity.dto.EmployeeCreateRequest;
import com.example.mappingobjectslab.entity.dto.EmployeeCreateResponse;
import com.example.mappingobjectslab.entity.dto.ManagerDto;

import java.util.List;

public interface EmployeeService {

  ManagerDto findOne(Long id);

  List<ManagerDto> findAll();

  EmployeeCreateResponse save(EmployeeCreateRequest createRequest);
}
