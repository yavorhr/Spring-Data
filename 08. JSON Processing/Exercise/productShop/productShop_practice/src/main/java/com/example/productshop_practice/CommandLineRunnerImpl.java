package com.example.productshop_practice;

import com.example.productshop_practice.constant.GlobalConstants;
import com.example.productshop_practice.model.dto.view.ProductDtoWithNamePriceAndSellerName;
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
    }
  }

  private void productsInRange() throws IOException {
    List<ProductDtoWithNamePriceAndSellerName> dtos =
            this.productService.findAllUsersWithMoreThanOneSoldProducts();

    String content = this.gson.toJson(dtos);

    Files
            .write(Path.of(GlobalConstants.PRODUCTS_IN_RANGE),
                    Collections.singleton(content));
  }

  private void seedData() throws IOException {
    this.categoriesService.seedCategories();
    this.userService.seedUsers();
    this.productService.seedProducts();
  }
}
