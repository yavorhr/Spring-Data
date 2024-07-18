package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

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
      case 4 -> printAllNotReleasedBooksByYear();
      case 5 -> printAllBooksReleasedBeforeDate();
      case 6 -> printAuthorsFirstNameEnding();
      case 7 -> printAllBooksWithTitleContain();
      case 8 -> printAllBooksWithAuthorsLastNameStartingWith();
      case 9 -> printAllBooksWithTitleLengthMoreThan();
      case 10 -> printTotalBooksCopies();
      case 11 -> printReducedBookInfoByTitle();
      case 12 -> increaseBookCopies();
      case 13 -> removeBooksWithCopiesLowerThan();
      case 14 -> storedProcedureForWrittenBooksByAuthorNames();
      case 90 -> printAllBooksAfterYear(2000);
      case 91 -> printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
      case 92 -> printAllAuthorsAndNumberOfTheirBooks();
      case 93 -> printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
    }
  }

  /* ================= 14. Stored Procedure ========================= */
  private void storedProcedureForWrittenBooksByAuthorNames() throws IOException {
    System.out.println("Please insert authors name: ");
    String[] tokens = this.bufferedReader.readLine().split(" ");
    String firstName = tokens[0];
    String lastName = tokens[1];

    int count = this.authorService.findAuthorsBooksCount(firstName,lastName);
    System.out.printf("%s %s has written %d books",firstName,lastName, count);
  }

  /* ================= 13. Remove Books ========================= */
  private void removeBooksWithCopiesLowerThan() throws IOException {
    System.out.println("Please enter copies: ");
    int copies = Integer.parseInt(this.bufferedReader.readLine());

    int affectedRows = this.bookService.removeALlBooksWithLowerCopiesThan(copies);
    System.out.printf("%d books were deleted!", affectedRows);
  }


  /* ============== 12. Increase Books Copies ================= */
  private void increaseBookCopies() throws IOException {
    System.out.println("Please enter after date: ");
    String dateInput = this.bufferedReader.readLine();

    System.out.println("Please enter copies: ");
    int copies = Integer.parseInt(this.bufferedReader.readLine());

    LocalDate date = LocalDate.parse(
            dateInput,
            DateTimeFormatter.ofPattern("dd MMM yyyy"));

    List<String> titlesToUpdate =
            this.bookService.findAllBooksAfterDate(date);

    this.bookService.updateBooksCopiesAfterYear(titlesToUpdate, copies);

    System.out.printf("%d books are released after %s, so total of %d book copies were added",
            titlesToUpdate.size(),
            dateInput,
            copies * titlesToUpdate.size());

  }

  /* ================= 11. Reduced Books ========================= */
  private void printReducedBookInfoByTitle() throws IOException {
    System.out.println("Please enter book title: ");
    String bookInput = bufferedReader.readLine();

    this.bookService
            .findInformationAboutBook(bookInput)
            .forEach(System.out::println);
  }

  /* ================ 10. Total Books Copies ==================== */
  private void printTotalBooksCopies() {
    this.authorService
            .findAllAuthorsAndTheirTotalCopies()
            .forEach(System.out::println);
  }

  /* =================== 9. Count Books ========================= */
  private void printAllBooksWithTitleLengthMoreThan() throws IOException {
    System.out.println("Please enter title length: ");
    int titleLength = Integer.parseInt(bufferedReader.readLine());

    System.out.println(this.bookService
            .findCountOfBooksWithTitleLengthLongerThan(titleLength));

  }

  /* =================== 8. Book Titles Search ======================== */
  private void printAllBooksWithAuthorsLastNameStartingWith() throws IOException {
    System.out.println("Please enter how the author's first name starts: ");
    String startStr = this.bufferedReader.readLine();

    bookService
            .findAllTitleWithAuthorWithLastNameStartsWith(startStr)
            .forEach(System.out::println);
  }

  /* =================== 7.	Book Search ========================== */
  private void printAllBooksWithTitleContain() throws IOException {
    System.out.println("Please enter a key word: ");
    String keyWord = this.bufferedReader.readLine();

    this.bookService
            .findAllBookTitlesWhereTitleContainString(keyWord)
            .forEach(System.out::println);
  }

  /* =================== 6.	Authors Search ========================== */
  private void printAuthorsFirstNameEnding() throws IOException {
    System.out.println("Please enter how the first name should end: ");
    String endStr = this.bufferedReader.readLine();

    this.authorService
            .findAuthorFirstNameEndsWithStr(endStr)
            .forEach(System.out::println);
  }

  /* =================== 5. Books Released Before Date ========================== */
  private void printAllBooksReleasedBeforeDate() throws IOException {
    System.out.println("Please enter date: ");

    LocalDate date = LocalDate.parse(this.bufferedReader.readLine(),
            DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    this.bookService
            .findAllBooksBeforeDate(date)
            .forEach(System.out::println);

  }

  /* =================== 4. Not Released Books ================================= */
  private void printAllNotReleasedBooksByYear() throws IOException {
    System.out.println("Please enter year: ");
    int year = Integer.parseInt(this.bufferedReader.readLine());

    this.bookService
            .findNotReleasedBookTitlesInYear(year)
            .forEach(System.out::println);
  }

  /* =================== 3. Books By Price ==================================== */
  private void printBooksByPriceRange() {
    this.bookService
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
