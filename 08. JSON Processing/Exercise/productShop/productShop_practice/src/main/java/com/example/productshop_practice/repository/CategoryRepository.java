package com.example.productshop_practice.repository;

import com.example.productshop_practice.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  @Query("SELECT Category.name FROM Category ")
  List<String> find();
}
