package com.example.mappingobjectslab;

import com.example.mappingobjectslab.entity.dto.RequestCreateManagerDto;
import com.example.mappingobjectslab.entity.dto.ManagerDto;
import com.example.mappingobjectslab.entity.dto.ResponseCreateManagerDto;
import com.example.mappingobjectslab.services.EmployeeService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    while (true) {
      System.out.println("Please insert command: ");
      String[] tokens = scanner.nextLine().split(" ");
      String command = tokens[0];

      switch (command) {
        //find 1
        case "find" -> findById(Long.parseLong(tokens[1]));
        case "findAll" -> findAll();
        //save {"firstName":"Ivan","lastName":"Ivanov","salary":3000.00,"birthday":"2024-07-04","address":"Chirpan","isOnHoliday":true}
        case "save" -> saveManager(tokens[1]);
        //save-from-file src/main/resources/manager.json
        case "save-from-file" -> saveManagerFromFilePath(tokens[1]);
        //findAll-to src/main/resources/allManagers.json
        case "findAll-to" -> saveAllManagersToFile(tokens[1]);
        default -> System.out.println("Invalid command");
      }
    }
  }

  private void saveAllManagersToFile(String path) throws IOException {
    List<ManagerDto> allManagers = this.employeeService.findAll();
    this.gson.toJson(allManagers, new FileWriter(path));
  }

  private void saveManagerFromFilePath(String path) throws FileNotFoundException {
    RequestCreateManagerDto manager = this.gson.fromJson(new FileReader(path), RequestCreateManagerDto.class);
    ResponseCreateManagerDto savedManager = this.employeeService.save(manager);

    System.out.println(this.gson.toJson(savedManager));


  }

  private void saveManager(String json) {
    RequestCreateManagerDto manager = this.gson.fromJson(json, RequestCreateManagerDto.class);
    ResponseCreateManagerDto savedManager = this.employeeService.save(manager);

    System.out.println(this.gson.toJson(savedManager));
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
