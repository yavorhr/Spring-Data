package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
  private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";
  private final BookRepository bookRepository;
  private final AuthorService authorService;
  private final CategoryService categoryService;

  public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
    this.bookRepository = bookRepository;
    this.authorService = authorService;
    this.categoryService = categoryService;
  }

  @Override
  public void seedBooks() throws IOException {
    if (bookRepository.count() > 0) {
      return;
    }

    Files
            .readAllLines(Path.of(BOOKS_FILE_PATH))
            .forEach(row -> {
              String[] bookInfo = row.split("\\s+");

              Book book = createBookFromInfo(bookInfo);

              bookRepository.save(book);
            });
  }

  @Override
  public List<String> findAllBooksAfterDate(LocalDate date) {
    return this.bookRepository.findAllByReleaseDateAfter(date)
            .stream()
            .map(Book::getTitle)
            .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public int updateBooksCopiesAfterYear(List<String> titles, int copies) {
    return this.bookRepository.updateBooksCopiesAfterYear(titles, copies);
  }

  @Override
  public List<Book> findAllBooksAfterYear(int year) {
    return bookRepository
            .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
  }

  @Override
  public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
    

    return bookRepository
            .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
            .stream()
            .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                    book.getAuthor().getLastName()))
            .distinct()
            .collect(Collectors.toList());
  }

  @Override
  public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
    return bookRepository
            .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
            .stream()
            .map(book -> String.format("%s %s %d",
                    book.getTitle(),
                    book.getReleaseDate(),
                    book.getCopies()))
            .collect(Collectors.toList());
  }

  @Override
  public List<String> findAllBookTitlesWithAgeRestriction(AgeRestriction ageRestriction) {
    return this.bookRepository
            .findAllByAgeRestriction(ageRestriction)
            .stream()
            .map(Book::getTitle)
            .collect(Collectors.toList());
  }

  @Override
  public List<String> findAllGoldBookTitlesWithCopiesLessThan5000() {
    return this.bookRepository
            .findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
            .stream()
            .map(Book::getTitle)
            .collect(Collectors.toList());
  }

  @Override
  public List<String> findAllBookTitlesWithPriceLessThan5MoreThan40() {
    return this.bookRepository
            .findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5L), BigDecimal.valueOf(40L))
            .stream()
            .map(b -> String.format("%s - $%.2f", b.getTitle(), b.getPrice()))
            .collect(Collectors.toList());
  }

  @Override
  public List<String> findNotReleasedBookTitlesInYear(int year) {
    LocalDate lower = LocalDate.of(year, 1, 1);
    LocalDate upper = LocalDate.of(year, 12, 31);

    return this.bookRepository
            .findAllByReleaseDateBeforeOrReleaseDateAfter(lower, upper)
            .stream()
            .map(Book::getTitle)
            .collect(Collectors.toList());
  }

  @Override
  public List<String> findAllBooksBeforeDate(LocalDate date) {
    return this.bookRepository.findAllByReleaseDateBefore(date)
            .stream()
            .map(b -> String.format("%s %s %.2f", b.getTitle(), b.getEditionType().name(), b.getPrice()))
            .collect(Collectors.toList());
  }

  @Override
  public List<String> findAllBookTitlesWhereTitleContainString(String keyWord) {
    return this.bookRepository.findAllByTitleContains(keyWord)
            .stream()
            .map(Book::getTitle)
            .collect(Collectors.toList());
  }

  @Override
  public List<String> findAllTitleWithAuthorWithLastNameStartsWith(String startStr) {
    return this.bookRepository
            .findAllByAuthor_LastNameStartsWith(startStr)
            .stream()
            .map(Book::getTitle)
            .collect(Collectors.toList());
  }

  @Override
  public String findCountOfBooksWithTitleLengthLongerThan(int length) {
    int booksCount = this.bookRepository.countAllByTitleLengthMoreThan(length);

    return String.format("There are %d books with longer title than %d symbols",
            booksCount, length);
  }

  @Override
  public List<String> findInformationAboutBook(String title) {
    return this.bookRepository
            .findAllByTitle(title)
            .stream()
            .map(b -> String.format("%s %s %s %.2f",
                    b.getTitle(),
                    b.getEditionType().name(),
                    b.getAgeRestriction().name(),
                    b.getPrice()))
            .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public int removeALlBooksWithLowerCopiesThan(int copies) {
    return this.bookRepository.removeAllByCopiesLessThan(copies);
  }


  private Book createBookFromInfo(String[] bookInfo) {
    EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
    LocalDate releaseDate = LocalDate
            .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
    Integer copies = Integer.parseInt(bookInfo[2]);
    BigDecimal price = new BigDecimal(bookInfo[3]);
    AgeRestriction ageRestriction = AgeRestriction
            .values()[Integer.parseInt(bookInfo[4])];
    String title = Arrays.stream(bookInfo)
            .skip(5)
            .collect(Collectors.joining(" "));

    Author author = authorService.getRandomAuthor();
    Set<Category> categories = categoryService
            .getRandomCategories();

    return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

  }
}
