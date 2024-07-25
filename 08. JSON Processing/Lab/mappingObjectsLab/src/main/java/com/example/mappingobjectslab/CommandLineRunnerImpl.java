package com.example.mappingobjectslab;

import com.example.mappingobjectslab.entity.dto.CreateManagerDto;
import com.example.mappingobjectslab.entity.dto.ManagerDto;
import com.example.mappingobjectslab.services.EmployeeService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final Scanner scanner;
  private final EmployeeService employeeService;
  private final Gson gson;

  public CommandLineRunnerImpl(Scanner scanner, EmployeeService employeeService, Gson gson) {
    this.scanner = scanner;
    this.employeeService = employeeService;
    this.gson = gson;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Please insert command: ");
    String[] tokens = scanner.nextLine().split(" ");
    String command = tokens[0];

    switch (command) {
      case "find" -> findById(Long.parseLong(tokens[1]));
      case "findAll" -> findAll();
      case "save" -> saveManager(tokens[1]);
      default -> System.out.println("Invalid command");
    }
  }

  private void saveManager(String json) {
    CreateManagerDto manager = this.gson.fromJson(json, CreateManagerDto.class);
    System.out.println();
  }

  private void findAll() {
    List<ManagerDto> managersList = this.employeeService.findAll();
    System.out.println(gson.toJson(managersList));
  }

  private void findById(long managerId) {
    ManagerDto manager = this.employeeService.findManagerById(managerId);
    String managerJSON = this.gson.toJson(manager);
    System.out.println(managerJSON);
  }

}
