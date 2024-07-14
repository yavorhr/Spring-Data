package com.example.springintro_practice.service.impl;


import com.example.springintro_practice.common.FilePath;
import com.example.springintro_practice.model.Category;
import com.example.springintro_practice.repository.CategoryRepository;
import com.example.springintro_practice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository categoryRepository;

  public CategoryServiceImpl(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void seedCategories() throws IOException {
    if (this.categoryRepository.count() > 0) {
      return;
    }

    Files.readAllLines(Path.of(FilePath.CATEGORIES_FILE_PATH))
            .stream()
            .filter(row -> !row.isEmpty())
            .forEach(categoryName -> {
              Category category = new Category(categoryName);

              categoryRepository.save(category);
            });


  }
}
