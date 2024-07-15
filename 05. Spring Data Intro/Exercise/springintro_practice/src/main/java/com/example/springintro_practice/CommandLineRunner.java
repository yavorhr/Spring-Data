package com.example.springintro_practice;

import com.example.springintro_practice.service.AuthorService;
import com.example.springintro_practice.service.BookService;
import com.example.springintro_practice.service.CategoryService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
  private final CategoryService categoryService;
  private final AuthorService authorService;
  private final BookService bookService;

  public CommandLineRunner(CategoryService categoryService, AuthorService authorService, BookService bookService) {
    this.categoryService = categoryService;
    this.authorService = authorService;
    this.bookService = bookService;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();
  }

  private void seedData() throws IOException {
    this.categoryService.seedCategories();
    this.authorService.seedAuthors();
    this.bookService.seedBooks();
  }
}
