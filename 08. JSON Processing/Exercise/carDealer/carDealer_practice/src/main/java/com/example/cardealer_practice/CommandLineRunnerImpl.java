package com.example.cardealer_practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final BufferedReader bufferedReader;

  public CommandLineRunnerImpl(BufferedReader bufferedReader) {
    this.bufferedReader = bufferedReader;
  }

  @Override
  public void run(String... args) throws Exception {
  seedData();
  }

  private void seedData() {
    seedSuppliers();
  }

  private void seedSuppliers() {
  }
}
