package com.example.productshop_practice.service.impl;

import com.example.productshop_practice.constant.GlobalConstants;
import com.example.productshop_practice.model.dto.CategorySeedDto;
import com.example.productshop_practice.model.dto.view.thirdQuery.CategoryDtoWithProductCountAvgTotalSum;
import com.example.productshop_practice.model.entity.Category;
import com.example.productshop_practice.repository.CategoryRepository;
import com.example.productshop_practice.service.CategoryService;
import com.example.productshop_practice.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoriesServiceImpl implements CategoryService {
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
    if (this.categoryRepository.count() == 0) {
      String string = Files.readString(Path.of(GlobalConstants.SEED_CATEGORIES_PATH));
      CategorySeedDto[] categorySeedDtos = this.gson.fromJson(string, CategorySeedDto[].class);


      Arrays.stream(categorySeedDtos)
              .filter(this.validationUtil::isValid)
              .map(d -> this.modelMapper.map(d, Category.class))
              .forEach(this.categoryRepository::save);
    }
  }

  @Override
  public Set<Category> findRandomCategories() {
    int categoryCount = ThreadLocalRandom.current().nextInt(1, 3);
    long allCategories = this.categoryRepository.count();

    Set<Category> categories = new HashSet<>();
    for (int i = 0; i < categoryCount; i++) {
      long randomId = ThreadLocalRandom.current().nextLong(1, allCategories);
      Category category = this.categoryRepository.findById(randomId).orElse(null);

      categories.add(category);
    }
    return categories;
  }

  @Override
  public List<CategoryDtoWithProductCountAvgTotalSum> findAllProductsWithAggregatedStats() {
    return this.categoryRepository
            .findAll()
            .stream()
            .map(c -> {
              CategoryDtoWithProductCountAvgTotalSum dto = new CategoryDtoWithProductCountAvgTotalSum();

              dto.setCategory(c.getName());
              dto.setProductsCount(c.getProducts().size());
              dto.setAveragePrice(
                      c.getProducts()
                              .stream()
                              .mapToDouble(cat -> cat.getPrice().doubleValue())
                              .average()
                              .orElse(0));
              dto.setTotalRevenue(
                      c.getProducts()
                              .stream()
                              .mapToDouble(cat -> cat.getPrice().doubleValue())
                              .sum());
              return dto;
            })
            .collect(Collectors.toList());
  }
}
