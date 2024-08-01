package com.example.cardealer_practice;

import com.example.cardealer_practice.model.repository.SaleRepository;
import com.example.cardealer_practice.model.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final BufferedReader bufferedReader;
  private final SupplierService supplierService;
  private final PartService partService;
  private final CarService carService;
  private final CustomerService customerService;
  private final SaleService saleService;

  public CommandLineRunnerImpl(BufferedReader bufferedReader, SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
    this.bufferedReader = bufferedReader;
    this.supplierService = supplierService;
    this.partService = partService;
    this.carService = carService;
    this.customerService = customerService;
    this.saleService = saleService;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();
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
