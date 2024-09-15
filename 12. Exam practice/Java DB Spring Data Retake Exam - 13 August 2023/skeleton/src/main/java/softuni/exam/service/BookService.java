package softuni.exam.service;


import softuni.exam.models.entity.Book;

import java.io.IOException;
import java.util.Optional;

public interface BookService {

    boolean areImported();

    String readBooksFromFile() throws IOException;

	String importBooks() throws IOException;

	Optional<Book> findBookByTitle(String title);

}
