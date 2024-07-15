package com.example.springintro_practice.service;

import com.example.springintro_practice.model.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {

  void seedCategories() throws IOException;

  Set<Category> getRandomCategories();
}
