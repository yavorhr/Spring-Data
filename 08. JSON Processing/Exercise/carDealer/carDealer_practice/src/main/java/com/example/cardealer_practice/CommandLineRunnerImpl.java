package com.example.cardealer_practice;

import com.example.cardealer_practice.constant.ProjectConstants;
import com.example.cardealer_practice.model.entity.dto.view.CarViewDto;
import com.example.cardealer_practice.model.entity.dto.view.CustomerViewDto;
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
    }
  }

  private void carsFromMakeToyota() throws IOException {
  List<CarViewDto> dtos = this.carService.findCarsByMake("Toyota");
    String content = this.gson.toJson(dtos);

    Files
            .write(Path.of(ProjectConstants.SECOND_QUERY_PATH),
                    Collections.singleton(content));
  }

  private void orderedCustomers() throws IOException {
    List<CustomerViewDto> customersDtos =
            this.customerService.findCustomersOrderByBirthDateAscYoungDriverAsc();

    String content = this.gson.toJson(customersDtos);

    Files
            .write(Path.of(ProjectConstants.FIRST_QUERY_PATH),
                    Collections.singleton(content));
  }

  private void seedData() throws IOException {
    seedSuppliers();
    seedParts();
    seedCustomers();
    seedSales();
    seedCars();
  }

  private void seedSales() {
    this.saleService.seedSales();
  }

  private void seedCustomers() throws IOException {
    this.customerService.seedCustomers();
  }


  // Helpers
  private void seedCars() throws IOException {
    this.carService.seedCars();
  }

  private void seedParts() throws IOException {
    this.partService.seedParts();
  }

  private void seedSuppliers() throws IOException {
    this.supplierService.seedSuppliers();
  }
}
