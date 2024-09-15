package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.BookSeedDto;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class BookServiceImpl implements BookService {
  private static final String BOOKS_FILE_PATH = "src/main/resources/files/json/books.json";
  private final BookRepository bookRepository;
  private final ModelMapper modelMapper;
  private final Gson gson;
  private final ValidationUtil validationUtil;

  public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
    this.bookRepository = bookRepository;
    this.modelMapper = modelMapper;
    this.gson = gson;
    this.validationUtil = validationUtil;
  }

  @Override
  public boolean areImported() {
    return this.bookRepository.count() > 0;
  }

  @Override
  public String readBooksFromFile() throws IOException {
    return Files.readString(Path.of(BOOKS_FILE_PATH));
  }

  @Override
  public String importBooks() throws IOException {
    StringBuilder sb = new StringBuilder();

    Arrays.stream(this.gson.fromJson(readBooksFromFile(), BookSeedDto[].class))
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (this.bookRepository.findByTitle(dto.getTitle()).isPresent()) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported book %s - %s", dto.getAuthor(), dto.getTitle())
                      : "Invalid book")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> this.modelMapper.map(dto, Book.class))
            .forEach(this.bookRepository::save);

    return sb.toString();
  }
}
