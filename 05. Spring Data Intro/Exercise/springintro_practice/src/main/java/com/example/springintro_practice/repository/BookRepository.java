package com.example.springintro_practice.repository;

import com.example.springintro_practice.model.Book;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

@Registered
public interface BookRepository extends JpaRepository<Book,Long> {

  List<Book> findAllByReleaseDateAfter(LocalDate releaseDate);

  List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

}
