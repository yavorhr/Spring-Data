package com.example.mappingobjectslab;

import com.example.mappingobjectslab.entity.dto.EmployeeDto;
import com.example.mappingobjectslab.entity.dto.ManagerDto;
import com.example.mappingobjectslab.entity.model.Employee;
import com.example.mappingobjectslab.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    System.out.println("Please insert command: ");
    String[] tokens = scanner.nextLine().split(" ");
    String command = tokens[0];

    switch (command) {
      case "find" -> printManagerToJson(Long.parseLong(tokens[1]));
      default -> System.out.println("Invalid command")
    }

  }

  private void printManagerToJson(long parseLong) {

  }

}
