package com.example.productshop_practice;

import com.example.productshop_practice.constant.GlobalConstants;
import com.example.productshop_practice.model.dto.view.thirdQuery.CategoryDtoWithProductCountAvgTotalSum;
import com.example.productshop_practice.model.dto.view.firstQuery.ProductWithNamePriceAndSellerNameDto;
import com.example.productshop_practice.model.dto.view.secondQuery.SellerWithSoldProductsDto;
import com.example.productshop_practice.model.dto.view.fourthQuery.SellersCountAndSellersSoldProductsDataDto;
import com.example.productshop_practice.service.CategoryService;
import com.example.productshop_practice.service.ProductService;
import com.example.productshop_practice.service.UserService;
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
  private final Gson gson;
  private final BufferedReader bufferedReader;
  private final CategoryService categoriesService;
  private final UserService userService;
  private final ProductService productService;

  public CommandLineRunnerImpl(Gson gson, BufferedReader bufferedReader, CategoryService categoriesService, UserService userService, ProductService productService) {
    this.gson = gson;
    this.bufferedReader = bufferedReader;
    this.categoriesService = categoriesService;
    this.userService = userService;
    this.productService = productService;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();

    System.out.println("Please select task: ");
    int task = Integer.parseInt(this.bufferedReader.readLine());

    switch (task) {
      case 1 -> productsInRange();
      case 2 -> soldProducts();
      case 3 -> categoriesByProductsCount();
      case 4 -> usersAndProducts();
    }
  }

  private void usersAndProducts() throws IOException {
    SellersCountAndSellersSoldProductsDataDto usersDto = this.userService.findAllUsersCountWithMoreThanOneSoldProducts();
    String content = this.gson.toJson(usersDto);

    writeToFile(content, GlobalConstants.USERS_AND_PRODUCTS);
  }

  private void categoriesByProductsCount() throws IOException {
    List<CategoryDtoWithProductCountAvgTotalSum> categories =
            this.categoriesService.findAllProductsWithAggregatedStats();

    String content = this.gson.toJson(categories);

    writeToFile(content, GlobalConstants.CATEGORIES_BY_PRODUCTS);
  }

  private void soldProducts() throws IOException {
    List<SellerWithSoldProductsDto> sellers =
            this.userService.findAllUsersWithMoreThanOneSoldProducts();

    String content = this.gson.toJson(sellers);

    writeToFile(content, GlobalConstants.SOLD_PRODUCTS);
  }

  private void productsInRange() throws IOException {
    List<ProductWithNamePriceAndSellerNameDto> dtos =
            this.productService.findAllUsersWithMoreThanOneSoldProducts();

    String content = this.gson.toJson(dtos);

    writeToFile(content, GlobalConstants.PRODUCTS_IN_RANGE);
  }

  // Helpers

  private void writeToFile(String content, String path) throws IOException {
    Files
            .write(Path.of(path),
                    Collections.singleton(content));
  }

  private void seedData() throws IOException {
    this.categoriesService.seedCategories();
    this.userService.seedUsers();
    this.productService.seedProducts();
  }
}
