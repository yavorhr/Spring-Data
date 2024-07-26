package com.example.productshop_practice;

import com.example.productshop_practice.service.CategoriesService;
import com.example.productshop_practice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final CategoriesService categoriesService;
  private final UserService userService;

  public CommandLineRunnerImpl(CategoriesService categoriesService, UserService userService) {
    this.categoriesService = categoriesService;
    this.userService = userService;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();
  }

  private void seedData() throws IOException {
    this.categoriesService.seedCategories();
    this.userService.seedUsers();
  }
}
