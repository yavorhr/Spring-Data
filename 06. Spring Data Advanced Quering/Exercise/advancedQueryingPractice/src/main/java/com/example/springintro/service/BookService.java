package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
  void seedBooks() throws IOException;

  List<String> findAllBooksAfterDate(LocalDate date);

  int updateBooksCopiesAfterYear(List<String> titles, int copies);

  List<Book> findAllBooksAfterYear(int year);

  List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

  List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

  List<String> findAllBookTitlesWithAgeRestriction(AgeRestriction ageRestriction);

  List<String> findAllGoldBookTitlesWithCopiesLessThan5000();

  List<String> findAllBookTitlesWithPriceLessThan5MoreThan40();

  List<String> findNotReleasedBookTitlesInYear(int year);

  List<String> findAllBooksBeforeDate(LocalDate date);


  List<String> findAllBookTitlesWhereTitleContainString(String keyWord);

  List<String> findAllTitleWithAuthorWithLastNameStartsWith(String startStr);

  String findCountOfBooksWithTitleLengthLongerThan(int titleLength);

  List<String> findInformationAboutBook(String bookInput);
}
