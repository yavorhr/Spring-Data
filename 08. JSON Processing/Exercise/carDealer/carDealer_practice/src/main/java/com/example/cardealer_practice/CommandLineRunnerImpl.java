package com.example.cardealer_practice;

import com.example.cardealer_practice.model.service.PartService;
import com.example.cardealer_practice.model.service.SupplierService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final BufferedReader bufferedReader;
  private final SupplierService supplierService;
  private final PartService partService;

  public CommandLineRunnerImpl(BufferedReader bufferedReader, SupplierService supplierService, PartService partService) {
    this.bufferedReader = bufferedReader;
    this.supplierService = supplierService;
    this.partService = partService;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();
  }

  private void seedData() throws IOException {
    seedSuppliers();
    seedParts();
  }

  // Helpers

  private void seedParts() {
  }

  private void seedSuppliers() throws IOException {
    this.supplierService.seedSuppliers();
    this.partService.seedParts();
  }
}
