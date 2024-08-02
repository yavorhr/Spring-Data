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

/*
* 1. find X -> return JSON for Manager with subordinates
* 2. findAll -> return JSON[] for all managers with their subordinates
* 3. save JSON object -> save manager from JSON text to the database and return ResponseCreateDto
* 4. save-from-file -> save Manager from json file from resources folder
* 5. findAll-to -> fid all managers and write them into file
*
* -- insert manually employees in DB for testing
* */

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
        case "find" -> findById(Long.parseLong(tokens[1]));
        case "findAll" -> findAll();
        case "save" -> saveManager(tokens[1]);
        case "save-from-file" -> saveManagerFromFilePath(tokens[1]);
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
