package com.example.springintro_practice;

import com.example.springintro_practice.service.AuthorService;
import com.example.springintro_practice.service.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
  private final CategoryService categoryService;
  private final AuthorService authorService;

  public CommandLineRunner(CategoryService categoryService, AuthorService authorService) {
    this.categoryService = categoryService;
    this.authorService = authorService;
  }

  @Override
  public void run(String... args) throws Exception {
    this.categoryService.seedCategories();
    this.authorService.seedAuthors();
  }
}
