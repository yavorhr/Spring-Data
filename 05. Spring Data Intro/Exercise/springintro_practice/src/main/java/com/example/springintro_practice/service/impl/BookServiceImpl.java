package com.example.springintro_practice.service.impl;

import com.example.springintro_practice.common.FilePath;
import com.example.springintro_practice.model.*;
import com.example.springintro_practice.repository.BookRepository;
import com.example.springintro_practice.service.AuthorService;
import com.example.springintro_practice.service.BookService;
import com.example.springintro_practice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
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
    if (this.bookRepository.count() >0){
      return;
    }

    Files.readAllLines(Path.of(FilePath.BOOKS_FILE_PATH))
            .forEach(row -> {
              Book book = createBook(row);
              this.bookRepository.save(book);
            });
  }

  private Book createBook(String row) {
    String[] bookInfo = row.split("\\s+");

    EditionTypeEnum editionType = EditionTypeEnum.values()[Integer.parseInt(bookInfo[0])];
    LocalDate releaseDate = LocalDate.parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
    Integer copies = Integer.parseInt(bookInfo[2]);
    BigDecimal price = new BigDecimal(bookInfo[3]);
    AgeRestrictionEnum ageRestriction = AgeRestrictionEnum.values()[Integer.parseInt(bookInfo[4])];

    String title = Arrays.stream(bookInfo)
            .skip(5)
            .collect(Collectors.joining(" "));

    Author author = this.authorService.getRandomAuthor();
    Set<Category> categories = this.categoryService.getRandomCategories();


    return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

  }
}
