package com.example.springintro_practice.repository;

import com.example.springintro_practice.model.Book;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface BookRepository extends JpaRepository<Book,Long> {
}
