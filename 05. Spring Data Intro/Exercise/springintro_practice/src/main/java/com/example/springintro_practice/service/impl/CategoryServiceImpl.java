package com.example.springintro_practice.service.impl;


import com.example.springintro_practice.common.FilePath;
import com.example.springintro_practice.model.Category;
import com.example.springintro_practice.repository.CategoryRepository;
import com.example.springintro_practice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

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

  @Override
  public Set<Category> getRandomCategories() {
    Set<Category> categories = new HashSet<>();

    int randInt = ThreadLocalRandom.current().nextInt(1, 3);
    long catRepoCount = this.categoryRepository.count();

    for (int i = 0; i < randInt; i++) {
      long randomId = ThreadLocalRandom.current().nextLong(1,catRepoCount+1);

      Category category = this.categoryRepository.findById(randomId).orElse(null);

      categories.add(category);
    }

    return categories;
  }
}
