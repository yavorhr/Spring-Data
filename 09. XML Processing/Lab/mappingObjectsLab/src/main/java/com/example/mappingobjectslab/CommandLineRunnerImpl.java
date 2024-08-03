package com.example.mappingobjectslab;


;
import com.example.mappingobjectslab.repositories.EmployeeRepository;
import com.example.mappingobjectslab.services.EmployeeService;
import com.example.mappingobjectslab.util.FormatConverter;
import com.example.mappingobjectslab.util.FormatConverterFactory;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
  private final EmployeeService employeeService;
  private final FormatConverterFactory factory;
  private final EmployeeRepository employeeRepository;
  private final ModelMapper modelMapper;

  public CommandLineRunnerImpl(EmployeeService employeeService, FormatConverterFactory factory, EmployeeRepository employeeRepository, ModelMapper modelMapper) {
    this.employeeService = employeeService;
    this.factory = factory;
    this.employeeRepository = employeeRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public void run(String... args) throws Exception {

    Stream.of(1,2,3,4,6)
            .map(el -> el * 2)
            .peek(el -> System.out.println(el * 2))
            .collect(Collectors.toList());

//        var source = new DateTimeSource();
//        source.setDate("2020-11-11 12:34:56");
//
//        DateTimeTarget target = this.modelMapper.map(
//                source,
//                DateTimeTarget.class
//        );

    var source = new FirstLastNameSource();
    source.setFirstName("pesho");
    source.setLastName("petrov");

    var target = this.modelMapper.map(
            source,
            FullNameTarget.class
    );

    List<EmployeeAverageSalaryDto> allWithAvgSalary =
            this.employeeRepository.findAllWithAvgSalary();
//        "2020-05-05 16:40:50"

    var sc = new Scanner(System.in);

    System.out.println("Enter format type: ");
    String formatType = sc.nextLine();

    FormatConverter converter = this.factory.create(formatType);
    converter.setPrettyPrint();

    TestDto testDto = converter.deserializeFromFile(
            "./src/main/resources/test-za-dati.xml",
            TestDto.class
    );

    var line = sc.nextLine();

    while (!line.equals("end")) {
      var cmdParts = line.split(" ", 2);
      switch (cmdParts[0]) {
        case "find":
          Long id = Long.parseLong(cmdParts[1]);
          ManagerDto managerById = this.employeeService.findOne(id);

          System.out.println(converter.serialize(managerById));
          break;
        case "findAll":
          List<ManagerDto> allManagers = this.employeeService.findAll();
          System.out.println(converter.serialize(new ManagerCollection(allManagers)));
          break;
        case "save":
          String input = cmdParts[1];

          EmployeeCreateRequest request
                  = converter.deserialize(input, EmployeeCreateRequest.class);


          EmployeeCreateResponse response = this.employeeService.save(
                  request
          );

          System.out.println(converter.serialize(response));
          break;
        case "save-from-file":
          EmployeeCreateRequest fileRequest = converter.deserializeFromFile(
                  cmdParts[1],
                  EmployeeCreateRequest.class
          );

          EmployeeCreateResponse fileResponse = this.employeeService.save(
                  fileRequest
          );

          System.out.println(converter.serialize(fileResponse));
          break;
        case "findAll-to":
          List<ManagerDto> managers = this.employeeService.findAll();
          converter.serialize(
                  new ManagerCollection(managers),
                  cmdParts[1] + "." + formatType
          );

          System.out.println("Written to file " + cmdParts[1]);

          break;
        case "change-format":
          converter = this.factory.create(cmdParts[1]);
          System.out.println("Format changed to " + cmdParts[1]);
          break;
        case "pretty-print":
          converter.setPrettyPrint();
          System.out.println("Success");
          break;
      }

      line = sc.nextLine();
    }


//
//        List<ManagerDto> managers = this.employeeService.findAll();
//        managers.forEach(managerDto -> {
//            if (managerDto.getSubordinates().isEmpty()) {
//                return;
//            }
//            System.out.println(managerDto.getFirstName() + " " + managerDto.getLastName() + " (" + managerDto.getSubordinates().size() + "):");
//            managerDto.getSubordinates().forEach(employeeDto -> {
//                System.out.println("\t" + employeeDto.getFirstName() + " " + employeeDto.getLastName() + " : " + employeeDto.getIncome());
//            });
//        });
  }
}
