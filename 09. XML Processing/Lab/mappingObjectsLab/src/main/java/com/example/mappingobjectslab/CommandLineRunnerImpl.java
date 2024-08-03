package com.example.mappingobjectslab;


import com.example.mappingobjectslab.entity.dto.ManagerCollection;
import com.example.mappingobjectslab.entity.dto.ManagerDto;;
import com.example.mappingobjectslab.entity.dto.RequestCreateManagerDto;
import com.example.mappingobjectslab.entity.dto.ResponseCreateManagerDto;
import com.example.mappingobjectslab.services.EmployeeService;
import jakarta.xml.bind.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
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


  public CommandLineRunnerImpl(Scanner scanner, EmployeeService employeeService) {
    this.scanner = scanner;
    this.employeeService = employeeService;
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

  }

  private void saveManagerFromFilePath(String path) throws FileNotFoundException {
////    RequestCreateManagerDto manager = this.gson.fromJson(new FileReader(path), RequestCreateManagerDto.class);
//    ResponseCreateManagerDto savedManager = this.employeeService.save(manager);

//    System.out.println(this.gson.toJson(savedManager));
  }

  private void saveManager(String input) throws JAXBException {

    /*
* <employee first_name="..." last_name="..." >
    <salary>2000</salary>
    <address>Mladost</address>
* </employee>
*
** <employee>first_name="XML" last_name="XML"><salary>2000</salary><address>Mladost</address></employee>
* */

    JAXBContext jaxbContext = JAXBContext.newInstance(ManagerCollection.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    unmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    RequestCreateManagerDto request = (RequestCreateManagerDto)
            unmarshaller.unmarshal(new ByteArrayInputStream(input.getBytes()));

    this.employeeService.save(request);

  }

  private void findAll() throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(ManagerCollection.class);
    Marshaller managerCollection = jaxbContext.createMarshaller();
    managerCollection.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    List<ManagerDto> managersList = this.employeeService.findAll();

    managerCollection.marshal(new ManagerCollection(managersList), System.out);
  }

  private void findById(long managerId) throws JAXBException, JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(ManagerDto.class);
    Marshaller managerMarshaller = jaxbContext.createMarshaller();
    managerMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    ManagerDto manager = this.employeeService.findManagerById(managerId);
    managerMarshaller.marshal(manager, System.out);
  }

}
