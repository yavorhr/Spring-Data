package com.example.dto_exercise.repository;

import com.example.dto_exercise.model.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

  @Query("SELECT count(g) FROM ShoppingCart s JOIN Game g ON s.id = g.id  WHERE g.title = :title")
  long doesGameExistInShoppingCart(@Param(value = "title") String title);

}