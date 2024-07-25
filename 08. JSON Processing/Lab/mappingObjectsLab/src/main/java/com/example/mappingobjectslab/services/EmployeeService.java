package com.example.mappingobjectslab.services;
import com.example.mappingobjectslab.entity.dto.ManagerDto;

import java.util.List;

public interface EmployeeService {

  ManagerDto findManagerById(long id);

  List<ManagerDto> findAll();
}
