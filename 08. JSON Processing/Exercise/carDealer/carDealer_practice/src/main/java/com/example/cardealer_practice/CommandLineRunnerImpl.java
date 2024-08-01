package com.example.cardealer_practice;

import com.example.cardealer_practice.constant.ProjectConstants;
import com.example.cardealer_practice.model.entity.dto.view.*;
import com.example.cardealer_practice.model.service.*;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final BufferedReader bufferedReader;
  private final Gson gson;
  private final SupplierService supplierService;
  private final PartService partService;
  private final CarService carService;
  private final CustomerService customerService;
  private final SaleService saleService;

  public CommandLineRunnerImpl(BufferedReader bufferedReader, Gson gson, SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
    this.bufferedReader = bufferedReader;
    this.gson = gson;
    this.supplierService = supplierService;
    this.partService = partService;
    this.carService = carService;
    this.customerService = customerService;
    this.saleService = saleService;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();

    System.out.println("Please select query number:");
    int number = Integer.parseInt(this.bufferedReader.readLine());
    switch (number) {
      case 1 -> orderedCustomers();
      case 2 -> carsFromMakeToyota();
      case 3 -> localSuppliers();
      case 4 -> carsWithParts();
      case 5 -> totalSalesByCustomer();
    }
  }

  private void totalSalesByCustomer() throws IOException {
    List<CustomerBoughtCarsViewDto> dtos = this.customerService.findCustomersByTopSales();
    String content = this.gson.toJson(dtos);
    String path = ProjectConstants.TOP_SALES;

    writeToFile(content, path);
  }

  private void carsWithParts() throws IOException {
    List<CarWithPartsDto> dtos = this.carService.findCarsWithParts();

    String content = this.gson.toJson(dtos);
    String path = ProjectConstants.CARS_WITH_PARTS;

    writeToFile(content, path);
  }

  private void localSuppliers() throws IOException {
    List<SupplierVewDto> dtos =
            this.supplierService.findLocalSuppliers();

    String content = this.gson.toJson(dtos);
    String path = ProjectConstants.LOCAL_SUPPLIERS;

    writeToFile(content, path);
  }

  private void carsFromMakeToyota() throws IOException {
    List<CarViewDto> dtos = this.carService.findCarsByMake("Toyota");

    String content = this.gson.toJson(dtos);
    String path = ProjectConstants.TOYOTA_CARS;

    writeToFile(content, path);
  }

  private void orderedCustomers() throws IOException {
    List<CustomerViewDto> dtos =
            this.customerService.findCustomersOrderByBirthDateAscYoungDriverAsc();

    String content = this.gson.toJson(dtos);
    String path = ProjectConstants.ORDERED_CUSTOMERS;

    writeToFile(content, path);
  }

  private void seedData() throws IOException {
    seedSuppliers();
    seedParts();
    seedCustomers();
    seedSales();
    seedCars();
  }

  // Helpers

  private void writeToFile(String content, String path) throws IOException {
    Files
            .write(Path.of(path),
                    Collections.singleton(content));
  }

  private void seedCars() throws IOException {
    this.carService.seedCars();
  }

  private void seedParts() throws IOException {
    this.partService.seedParts();
  }

  private void seedSuppliers() throws IOException {
    this.supplierService.seedSuppliers();
  }

  private void seedSales() {
    this.saleService.seedSales();
  }

  private void seedCustomers() throws IOException {
    this.customerService.seedCustomers();
  }

}
