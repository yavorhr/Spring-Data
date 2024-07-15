package com.example.springintro_practice.service;

import com.example.springintro_practice.model.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
  void seedBooks() throws IOException;

  String findAllBooksAfterYear(int i);

  String findAllBooksAuthorsWithBooksBeforeYear(int year);

  List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);
}
