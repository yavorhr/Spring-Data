package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
      case 2 -> selectShampooBySizeOrLabel();
      case 3 -> selectShampoosByHigherPrice();
    }
  }

  private void selectShampoosByHigherPrice() {
    System.out.println("Please enter price criteria: ");

    BigDecimal price = new BigDecimal(scanner.nextLine());

    List<String> allShampoosByPrice =
            this.shampooService.findAllShampoosByPrice(price);

    allShampoosByPrice.forEach(System.out::println);
  }

  private void selectShampooBySizeOrLabel() {
    System.out.println("Please enter shampoo size or label id :");
    String size = scanner.nextLine();
    long labelId = Long.parseLong(scanner.nextLine());

    List<String> shampoosBySizeOrLabel = this.shampooService
            .findAllShampoosBySizeOrLabel(Size.valueOf(size), labelId);

    shampoosBySizeOrLabel.forEach(System.out::println);
  }

  private void selectShampooBySize() {
    System.out.println("Please enter shampoo size :");
    String size = scanner.nextLine();

    List<String> shampoosBySize = this.shampooService
            .findAllShampoosBySize(size);

    shampoosBySize.forEach(System.out::println);
  }
}
