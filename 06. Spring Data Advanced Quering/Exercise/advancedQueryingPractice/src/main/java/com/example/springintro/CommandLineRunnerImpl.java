package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final CategoryService categoryService;
  private final AuthorService authorService;
  private final BookService bookService;
  private final BufferedReader bufferedReader;

  public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
    this.categoryService = categoryService;
    this.authorService = authorService;
    this.bookService = bookService;
    this.bufferedReader = bufferedReader;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();

    System.out.println("Please enter exercise number: ");
    int number = Integer.parseInt(this.bufferedReader.readLine());

    switch (number) {
      case 1 -> printBooksTitlesByAgeRestriction();
      case 2 -> printOnlyGoldenBooksEditionWithLessThan5000Copies();
      case 3 -> printBooksByPriceRange();
      case 90 -> printAllBooksAfterYear(2000);
      case 91 -> printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
      case 92 -> printAllAuthorsAndNumberOfTheirBooks();
      case 93 -> printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
    }
  }

  /* =================== 3. Books By Price ==================================== */
  private void printBooksByPriceRange() {
    bookService
            .findAllBookTitlesWithPriceLessThan5MoreThan40()
            .forEach(System.out::println);
  }

  /* =================== 2. Golden Books ===================================== */
  private void printOnlyGoldenBooksEditionWithLessThan5000Copies() {
    this.bookService
            .findAllGoldBookTitlesWithCopiesLessThan5000()
            .forEach(System.out::println);

  }

  /* ============= 1. Books Titles by Age Restriction ======================== */
  private void printBooksTitlesByAgeRestriction() throws IOException {
    System.out.println("Please enter age restriction: ");
    AgeRestriction ageRestriction = AgeRestriction.valueOf(this.bufferedReader.readLine().toUpperCase());

    this.bookService
            .findAllBookTitlesWithAgeRestriction(ageRestriction)
            .forEach(System.out::println);
  }

  private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
    bookService
            .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
            .forEach(System.out::println);
  }

  private void printAllAuthorsAndNumberOfTheirBooks() {
    authorService
            .getAllAuthorsOrderByCountOfTheirBooks()
            .forEach(System.out::println);
  }

  private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
    bookService
            .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
            .forEach(System.out::println);
  }

  private void printAllBooksAfterYear(int year) {
    bookService
            .findAllBooksAfterYear(year)
            .stream()
            .map(Book::getTitle)
            .forEach(System.out::println);
  }

  private void seedData() throws IOException {
    categoryService.seedCategories();
    authorService.seedAuthors();
    bookService.seedBooks();
  }
}
