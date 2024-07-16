package com.example.advquerying;

import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  Scanner scanner = new Scanner(System.in);
  private final ShampooService shampooService;

  public CommandLineRunnerImpl(ShampooService shampooService) {
    this.shampooService = shampooService;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Please enter task number:");
    int taskNumber = Integer.parseInt(scanner.nextLine());

    switch (taskNumber) {
      case 1 -> selectShampooBySize();
    }
  }

  private void selectShampooBySize() {
    System.out.println("Please enter shampoo size :");
    String size = scanner.nextLine();

    List<String> shampoos = this.shampooService.findAllShampoosBySize(size);
  }
}
