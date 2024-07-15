package com.example.springintro_practice.service.impl;

import com.example.springintro_practice.common.FilePath;
import com.example.springintro_practice.model.Author;
import com.example.springintro_practice.repository.AuthorRepository;
import com.example.springintro_practice.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthorServiceImpl implements AuthorService {
  private final AuthorRepository authorRepository;

  public AuthorServiceImpl(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public void seedAuthors() throws IOException {
    if (this.authorRepository.count() > 0) {
      return;
    }

    Files.readAllLines(Path.of(FilePath.AUTHORS_FILE_PATH))
            .forEach(this::saveAuthorToDatabase);

  }

  @Override
  public Author getRandomAuthor() {
    long randomId = ThreadLocalRandom.current().nextLong(1, this.authorRepository.count() + 1);

    return authorRepository.findById(randomId).orElse(null);
  }


  // Helpers
  private void saveAuthorToDatabase(String row) {
    String[] tokens = row.split("\\s+");
    String firstName = tokens[0];
    String lastName = tokens[1];

    Author author = new Author(firstName, lastName);
    this.authorRepository.save(author);
  }
}
