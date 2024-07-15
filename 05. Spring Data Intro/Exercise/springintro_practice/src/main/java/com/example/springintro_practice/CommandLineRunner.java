package com.example.springintro_practice;

import com.example.springintro_practice.service.AuthorService;
import com.example.springintro_practice.service.BookService;
import com.example.springintro_practice.service.CategoryService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
  Scanner scanner = new Scanner(System.in);
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

    //printAllBooksAfterYear(2000);
    //printAllAuthorsNamesWithBooksWithReleaseDateBefore1990(1990);
    //printAllAuthorsAndNumberOfTheirBooks();
    //printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");
  }

  private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
    this.bookService
            .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName,lastName)
            .forEach(System.out::println);
  }


  // Helpers
  private void printAllBooksAfterYear(int year) {
    System.out.println(this.bookService.findAllBooksAfterYear(2000));
  }

  private void printAllAuthorsAndNumberOfTheirBooks() {
    this.authorService
            .getAllAuthorsOrderByCountOfTheirBooks()
            .forEach(System.out::println);
  }

  private void printAllAuthorsNamesWithBooksWithReleaseDateBefore1990(int year) {
    System.out.println(this.bookService
            .findAllBooksAuthorsWithBooksBeforeYear(year));
  }

  private void seedData() throws IOException {
    this.categoryService.seedCategories();
    this.authorService.seedAuthors();
    this.bookService.seedBooks();
  }
}
