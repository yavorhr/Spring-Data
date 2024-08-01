package com.example.cardealer_practice;

import com.example.cardealer_practice.model.entity.Part;
import com.example.cardealer_practice.model.service.CarService;
import com.example.cardealer_practice.model.service.PartService;
import com.example.cardealer_practice.model.service.SupplierService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final BufferedReader bufferedReader;
  private final SupplierService supplierService;
  private final PartService partService;
  private final CarService carService;

  public CommandLineRunnerImpl(BufferedReader bufferedReader, SupplierService supplierService, PartService partService, CarService carService) {
    this.bufferedReader = bufferedReader;
    this.supplierService = supplierService;
    this.partService = partService;
    this.carService = carService;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();
  }

  private void seedData() throws IOException {
    seedSuppliers();
    seedParts();
    seedCars();
    seedCustomers();
  }

  private void seedCustomers() {

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
