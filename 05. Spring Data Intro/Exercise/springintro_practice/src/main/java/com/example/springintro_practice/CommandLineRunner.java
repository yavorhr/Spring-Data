package com.example.springintro_practice;

import com.example.springintro_practice.service.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
  private final CategoryService categoryService;

  public CommandLineRunner(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @Override
  public void run(String... args) throws Exception {
    this.categoryService.seedCategories();
  }
}
