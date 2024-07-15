package com.example.springintro_practice.service;


import java.io.IOException;
import java.util.List;

public interface BookService {
  void seedBooks() throws IOException;

  List<String> findAllBooksAfterYear(int i);

  List<String> findAllBooksAuthorsWithBooksBeforeYear(int year);

  List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);
}
