package com.example.shop;

import com.example.shop.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;

@Service
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final BufferedReader bufferedReader;
  private final CategoryService categoryService;

  public CommandLineRunnerImpl(BufferedReader bufferedReader, CategoryService categoryService) {
    this.bufferedReader = bufferedReader;
    this.categoryService = categoryService;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();
  }

  private void seedData() {
    this.categoryService.seedCategories();
  }
}
