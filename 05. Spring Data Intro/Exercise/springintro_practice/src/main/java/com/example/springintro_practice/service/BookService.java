package com.example.springintro_practice.service;

import java.io.IOException;

public interface BookService {
  void seedBooks() throws IOException;

  String findAllBooksAfterYear(int i);
}
