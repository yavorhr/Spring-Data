package com.example.productshop_practice.service.impl;

import com.example.productshop_practice.constant.GlobalConstants;
import com.example.productshop_practice.repository.CategoryRepository;
import com.example.productshop_practice.service.CategoriesService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CategoriesServiceImpl implements CategoriesService {
  private final Gson gson;
  private final ModelMapper modelMapper;
  private final CategoryRepository categoryRepository;

  public CategoriesServiceImpl(Gson gson, ModelMapper modelMapper, CategoryRepository categoryRepository) {
    this.gson = gson;
    this.modelMapper = modelMapper;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void seedCategories() throws IOException {
    String string = Files.readString(Path.of(GlobalConstants.SEED_CATEGORIES_PATH));

    System.out.println();
  }
}
