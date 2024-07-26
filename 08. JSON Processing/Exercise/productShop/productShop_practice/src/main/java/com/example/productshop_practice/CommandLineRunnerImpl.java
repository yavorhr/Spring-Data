package com.example.productshop_practice;

import com.example.productshop_practice.service.CategoriesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final CategoriesService categoriesService;

  public CommandLineRunnerImpl(CategoriesService categoriesService) {
    this.categoriesService = categoriesService;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();
  }

  private void seedData() {
    this.categoriesService.seedCategories();
  }
}
