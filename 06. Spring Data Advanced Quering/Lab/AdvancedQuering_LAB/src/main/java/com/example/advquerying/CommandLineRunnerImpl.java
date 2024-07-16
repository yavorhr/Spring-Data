package com.example.advquerying;

import com.example.advquerying.entities.Size;

import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  Scanner scanner = new Scanner(System.in);
  private final ShampooService shampooService;
  private final IngredientService ingredientService;

  public CommandLineRunnerImpl(ShampooService shampooService, IngredientService ingredientService) {
    this.shampooService = shampooService;
    this.ingredientService = ingredientService;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Please enter task number:");
    int taskNumber = Integer.parseInt(scanner.nextLine());

    switch (taskNumber) {
      case 1 -> selectShampooBySize();
      case 2 -> selectShampooBySizeOrLabel();
      case 3 -> selectShampoosByHigherPrice();
      case 4 -> selectAllIngredientsByFirstLetters();
      case 5 -> selectAllIngredientsFromList();
      case 6 -> countShampoosByPriceLowerThenGiven();
      case 7 -> selectShampoosByIngredients();
      case 8 -> selectShampoosByIngredientsCount();
      case 9 -> deleteIngredientByName();
      case 10 -> updateIngredientsPriceBy10Percents();
      case 11 -> updateSelectedIngredientsPrices();
    }
  }

  private void updateSelectedIngredientsPrices() {
    System.out.println("How many times you would like to multiply the prices ?");
    BigDecimal multiplier = new BigDecimal (scanner.nextLine());
    System.out.println("Please provide the ingredient's names, which need to be updated?");
    List<String> ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

    int updatedIngredients = this.ingredientService.increaseSelectedIngredientsByMultiplier(multiplier, ingredients);
    System.out.printf("%d ingredient's prices were multiplied by %.0f times!\n", updatedIngredients, multiplier);
  }

  private void updateIngredientsPriceBy10Percents() {
    int ingredientsCountUpdated = this.ingredientService.increaseIngredientsPriceBy10percent();
    System.out.printf("%d ingredient's prices were increased with 10%%n", ingredientsCountUpdated);
  }

  private void deleteIngredientByName() {
    System.out.println("Please enter ingredient name to remove: ");
    String name = scanner.nextLine();

    this.ingredientService.removeIngredientByName(name);
  }

  private void selectShampoosByIngredientsCount() {
    System.out.println("Please select count of ingredients: ");
    long count = Long.parseLong(scanner.nextLine());

    Set<String> allByIngredientsCount =
            this.shampooService.findAllShampoosByIngredientsCountLessThanGiven(count);

    allByIngredientsCount.forEach(System.out::println);
  }

  private void selectShampoosByIngredients() {
    System.out.println("Please enter ingredients: ");
    List<String> ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

    Set<String> allByIngredients = this.shampooService.findAllByIngredients(ingredients);
    allByIngredients.forEach(System.out::println);
  }

  private void countShampoosByPriceLowerThenGiven() {
    System.out.println("Please enter price: ");
    BigDecimal price = new BigDecimal(scanner.nextLine());
    long count = this.shampooService.countShampoosByPriceLowerThenGiven(price);

    System.out.println(count);
  }

  private void selectAllIngredientsFromList() {
    System.out.println("Please paster the ingredients, which you are looking for:");
    List<String> collect = Arrays.asList(scanner.nextLine().split("\\s+"));
    List<String> allIngredientsFromList =
            this.ingredientService.findAllIngredientsFromList(collect);

    allIngredientsFromList.forEach(System.out::println);
  }

  private void selectAllIngredientsByFirstLetters() {
    System.out.println("Please enter the first letter/s, which the ingredient/s start/s with: ");
    String letters = scanner.nextLine();

    List<String> allIngredientsByFirstLetters =
            this.ingredientService.findAllIngredientsByFirstLetters(letters);

    allIngredientsByFirstLetters.forEach(System.out::println);
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
