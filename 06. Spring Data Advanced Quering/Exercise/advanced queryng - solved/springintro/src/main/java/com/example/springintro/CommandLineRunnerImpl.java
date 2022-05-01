package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Please select ex: ");
        int exNum = Integer.parseInt(bufferedReader.readLine());

        switch (exNum) {
            case 1: booksTitlesByAgeRestriction();
            case 2: goldenBooks();
            case 3: booksByPrice();
            case 4: notReleasedBooks();
            case 5: booksReleaseBefore();
            case 6: authorsSearch();
            case 7: bookSearch();
            case 8: booksTitleSearch();
            case 9: countBooks();
            case 10: totalBookCopies();
            case 11: reducedBook();
        }


        //printAllBooksAfter2000(2000);
        //printAllAuthorsNamesWithBooksWithReleaseDateBefore1990(1990);
        //printAllAuthorsAndNumberOfTheirBooks();
        //printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");
    }

    private void reducedBook() throws IOException {
        System.out.println("Please enter book title: ");
        String bookInput = bufferedReader.readLine();

        this.bookService
                .findInformationAboutBook(bookInput)
                .forEach(System.out::println);
    }

    private void totalBookCopies() {
        authorService
                .findAllAuthorsAndTheirTotalCopies()
                .forEach(System.out::println);
    }

    private void countBooks() throws IOException {
        System.out.println("Please enter title length: ");
        int titleLength = Integer.parseInt(bufferedReader.readLine());
        System.out.println(this.bookService
                .findCountOfBooksWithTitleLengthLongerThan(titleLength));
    }

    private void booksTitleSearch() throws IOException {
        System.out.println("Please enter Author last name starts with str: ");
        String startStringInput = bufferedReader.readLine();

        bookService.findAllTitleWithAuthorWithLastNameStartsWith(startStringInput)
                .forEach(System.out::println);
    }

    private void bookSearch() throws IOException {
        System.out.println("Enter containing str: ");
        String containString = bufferedReader.readLine();
        bookService
                .findAllBooTitlesWhereTitleContainString(containString)
                .forEach(System.out::println);

    }

    private void authorsSearch() throws IOException {
        System.out.println("Enter first name ends with str: ");
        String endStr = bufferedReader.readLine();

        authorService
                .findAuthorFirstNameEndsWithStr(endStr)
                .forEach(System.out::println);
    }

    private void booksReleaseBefore() throws IOException {
        System.out.println("Please enter date in dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        bookService
                .findAllBooksBeforeDate(localDate)
                .forEach(System.out::println);
    }

    private void notReleasedBooks() throws IOException {
        System.out.println("Please enter year: ");
        int year = Integer.parseInt(bufferedReader.readLine());

        bookService
                .findNotReleasedBookTitlesInYear(year)
                .forEach(System.out::println);
    }

    private void booksByPrice() {
        bookService
                .findAllBookTitlesWithPriceLessThan5MoreThan40()
                .forEach(System.out::println);
    }

    private void goldenBooks() {
        bookService
                .findAllGoldBookTitlesWithCopiesLessThan5000()
                .forEach(System.out::println);
    }

    private void booksTitlesByAgeRestriction() throws IOException {
        System.out.println("Please enter age restriction: ");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());

        this.bookService
                .findAllBookTitlesWithAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName).forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBefore1990(int year) {
        bookService
                .findAllBooksAuthorsWithBooksBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfter2000(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();

    }
}


