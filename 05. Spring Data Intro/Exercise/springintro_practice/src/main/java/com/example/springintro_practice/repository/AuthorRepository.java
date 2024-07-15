package com.example.springintro_practice.repository;

import com.example.springintro_practice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

  @Query("SELECT a FROM Author a ORDER BY SIZE(a.books) DESC")
  List<Author> findAllByBooksSize();


}
