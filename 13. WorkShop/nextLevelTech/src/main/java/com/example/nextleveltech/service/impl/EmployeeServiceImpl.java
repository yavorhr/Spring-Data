package com.example.nextleveltech.service.impl;

import com.example.nextleveltech.repositoriy.EmployeeRepository;
import com.example.nextleveltech.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private static final String EMPLOYEES_FILE_PATH = "files/xmls/employees.xml";

  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public boolean areFilesImported() {
    return employeeRepository.existsAllBy();
  }

  @Override
  public String getXmlDataForImport() throws IOException {
    return new String(this.getClass().getClassLoader().getResourceAsStream(EMPLOYEES_FILE_PATH).readAllBytes(), StandardCharsets.UTF_8);
  }
}
