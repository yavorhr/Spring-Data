package com.example.mappingobjectslab;

import com.example.mappingobjectslab.entity.dto.EmployeeDto;
import com.example.mappingobjectslab.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final Scanner scanner;
  private final EmployeeService employeeService;

  public CommandLineRunnerImpl(Scanner scanner, EmployeeService employeeService) {
    this.scanner = scanner;
    this.employeeService = employeeService;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Please select task number: ");
    int taskNumber = Integer.parseInt(scanner.nextLine());

    switch (taskNumber) {
      case 1 -> simpleMapping();
    }

  }

  private void simpleMapping() {
    System.out.println("Please select employee id: ");
    int employeeId = Integer.parseInt(scanner.nextLine());

    EmployeeDto employeeDto = this.employeeService.findEmployeeById(employeeId);

    System.out.printf("%s %s %.2f\n", employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getSalary());
  }
}
