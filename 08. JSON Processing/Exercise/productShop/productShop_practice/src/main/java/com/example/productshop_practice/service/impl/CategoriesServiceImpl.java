package com.example.productshop_practice.service.impl;

import com.example.productshop_practice.constant.GlobalConstants;
import com.example.productshop_practice.model.dto.CategorySeedDto;
import com.example.productshop_practice.model.entity.Category;
import com.example.productshop_practice.repository.CategoryRepository;
import com.example.productshop_practice.service.CategoriesService;
import com.example.productshop_practice.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CategoriesServiceImpl implements CategoriesService {
  private final Gson gson;
  private final ModelMapper modelMapper;
  private final CategoryRepository categoryRepository;
  private final ValidationUtil validationUtil;

  public CategoriesServiceImpl(Gson gson, ModelMapper modelMapper, CategoryRepository categoryRepository, ValidationUtil validationUtil) {
    this.gson = gson;
    this.modelMapper = modelMapper;
    this.categoryRepository = categoryRepository;
    this.validationUtil = validationUtil;
  }

  @Override
  public void seedCategories() throws IOException {
    String string = Files.readString(Path.of(GlobalConstants.SEED_CATEGORIES_PATH));
    CategorySeedDto[] categorySeedDtos = this.gson.fromJson(string, CategorySeedDto[].class);

    if (this.categoryRepository.count() == 0) {
      Arrays.stream(categorySeedDtos)
              .filter(this.validationUtil::isValid)
              .map(d -> this.modelMapper.map(d, Category.class))
              .forEach(this.categoryRepository::save);
    }


  }
}
