package com.example;

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

//    System.out.println("Please select task number");
//    int taskNumber = Integer.parseInt(this.bufferedReader.readLine());

  }

  private void seedData() {

  }
}
