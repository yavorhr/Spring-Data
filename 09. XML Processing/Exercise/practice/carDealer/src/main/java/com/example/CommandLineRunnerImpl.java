package com.example;

import com.example.cardealer.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;

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

  private void seedData() {
    this.supplierService.seedSuppliers();
  }
}
