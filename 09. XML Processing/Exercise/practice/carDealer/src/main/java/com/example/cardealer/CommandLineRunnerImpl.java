package com.example.cardealer;

import com.example.cardealer.constant.ProjectConstants;
import com.example.cardealer.model.dto.view.FirstQuery.CustomersRootViewDto;
import com.example.cardealer.service.*;
import com.example.cardealer.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final BufferedReader bufferedReader;
  private final CarService carService;
  private final CustomerService customerService;
  private final PartService partService;
  private final SaleService saleService;
  private final SupplierService supplierService;
  private final XmlParser xmlParser;

  public CommandLineRunnerImpl(BufferedReader bufferedReader, CarService carService, CustomerService customerService, PartService partService, SaleService saleService, SupplierService supplierService, XmlParser xmlParser) {
    this.bufferedReader = bufferedReader;
    this.carService = carService;
    this.customerService = customerService;
    this.partService = partService;
    this.saleService = saleService;
    this.supplierService = supplierService;
    this.xmlParser = xmlParser;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();

    System.out.println("Please select task number");
    int taskNumber = Integer.parseInt(this.bufferedReader.readLine());

    switch (taskNumber){
      case 1 -> orderedCustomers();
    }
  }

  private void orderedCustomers() throws JAXBException {
    CustomersRootViewDto rootDto =
            this.customerService.findAllCustomersOrderedByBdayAscAndYoungDrivers();
   this.xmlParser.writeToFile(ProjectConstants.FIRST_QUERY, rootDto);
  }

  // Helpers
  private void seedData() throws JAXBException, FileNotFoundException {
    this.supplierService.seedSuppliers();
    this.partService.seedParts();
    this.carService.seedCars();
    this.customerService.seedCustomers();
    this.saleService.seedSales();
  }
}
