package com.example.mappingobjectslab.services;
import com.example.mappingobjectslab.entity.dto.RequestCreateManagerDto;
import com.example.mappingobjectslab.entity.dto.ManagerDto;
import com.example.mappingobjectslab.entity.dto.ResponseCreateManagerDto;

import java.util.List;

public interface EmployeeService {

  ManagerDto findManagerById(long id);

  List<ManagerDto> findAll();

  ResponseCreateManagerDto save(RequestCreateManagerDto manager);
}
