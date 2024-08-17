package com.example.cardealer;

import com.example.cardealer.service.*;
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

  public CommandLineRunnerImpl(BufferedReader bufferedReader, CarService carService, CustomerService customerService, PartService partService, SaleService saleService, SupplierService supplierService) {
    this.bufferedReader = bufferedReader;
    this.carService = carService;
    this.customerService = customerService;
    this.partService = partService;
    this.saleService = saleService;
    this.supplierService = supplierService;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();

//    System.out.println("Please select task number");
//    int taskNumber = Integer.parseInt(this.bufferedReader.readLine());

  }

  private void seedData() throws JAXBException, FileNotFoundException {
    this.supplierService.seedSuppliers();
    this.partService.seedParts();
    this.carService.seedCars();
    this.customerService.seedCustomers();
  }
}
