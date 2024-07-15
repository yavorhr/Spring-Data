package com.example.springintro_practice.service;

import com.example.springintro_practice.model.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

  void seedAuthors() throws IOException;

  Author getRandomAuthor();

  List<String> getAllAuthorsOrderByCountOfTheirBooks();
}
