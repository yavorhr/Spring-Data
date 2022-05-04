package com.example.xmlexercise.service;

import com.example.xmlexercise.model.dto.Shop_query3.CategoryRootDto;
import com.example.xmlexercise.model.dto.Shop_SeedDtos.CategorySeedDto;
import com.example.xmlexercise.model.entity.Category;

import java.util.List;

public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categories);

    long getEntityCount();

    List<Category> getRandomCategories();

    CategoryRootDto getCategoriesOrderedByProductsCountPlusAvgPrice();
}
