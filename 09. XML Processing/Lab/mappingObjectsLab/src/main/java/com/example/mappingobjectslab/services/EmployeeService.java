package com.example.mappingobjectslab.services;

import java.util.List;

public interface EmployeeService {

  ManagerDto findManagerById(long id);

  List<ManagerDto> findAll();

  ResponseCreateManagerDto save(RequestCreateManagerDto manager);
}
