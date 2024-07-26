package com.example.productshop_practice.service;

import com.example.productshop_practice.model.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
  void seedCategories() throws IOException;

  Set<Category> findRandomCategories();
}
