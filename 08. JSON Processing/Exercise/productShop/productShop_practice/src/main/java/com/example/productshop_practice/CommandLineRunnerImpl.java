package com.example.productshop_practice;

import com.example.productshop_practice.service.CategoriesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

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

  private void seedData() throws IOException {
    this.categoriesService.seedCategories();
  }
}
