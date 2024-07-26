package com.example.productshop_practice;

import com.example.productshop_practice.service.CategoriesService;
import com.example.productshop_practice.service.ProductService;
import com.example.productshop_practice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final CategoriesService categoriesService;
  private final UserService userService;
  private final ProductService productService;

  public CommandLineRunnerImpl(CategoriesService categoriesService, UserService userService, ProductService productService) {
    this.categoriesService = categoriesService;
    this.userService = userService;
    this.productService = productService;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();
  }

  private void seedData() throws IOException {
    this.categoriesService.seedCategories();
    this.userService.seedUsers();
    this.productService.seedProducts();
  }
}
