package com.example.mappingobjectslab;

import com.example.mappingobjectslab.entity.dto.EmployeeDto;
import com.example.mappingobjectslab.entity.dto.ManagerDto;
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
    System.out.println("Please select task number: ");
    int taskNumber = Integer.parseInt(scanner.nextLine());

    switch (taskNumber) {
      case 1 -> simpleMapping();
      case 2 -> advancedMapping();
      case 3 -> projection();
    }

  }

  private void projection() {
    List<EmployeeDto> employees = this.employeeService.
            findAllEmployeesBornBefore1990(LocalDate.of(1990, 1, 1));

    if (employees.size() == 0) {
      System.out.println("There are no employees born before 1990");
    } else {
      employees
              .stream()
              .map(e -> String.format("%s %s %.2f - Manager: %s",
                      e.getFirstName(),
                      e.getLastName(),
                      e.getSalary(),
                      e.getManager() != null ? e.getManager().getLastName() : "[no manager]"))
              .forEach(System.out::println);
    }
  }

  private void advancedMapping() {
    // Nested mapping
    System.out.println("Please select manager id: ");
    int managerId = Integer.parseInt(scanner.nextLine());

    ManagerDto manager = this.employeeService.findManagerById(managerId);

    System.out.printf("%s %s | Employees: %d\n%s\n",
            manager.getFirstName(),
            manager.getLastName(),
            manager.getSubordinates().size(),
            getSubordinatesData(manager.getSubordinates()));
  }

  private String getSubordinatesData(List<EmployeeDto> employees) {
    return employees
            .stream()
            .map(e -> String.format("\t- %s %s %.2f",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getSalary()))
            .collect(Collectors.joining("\n"));
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
