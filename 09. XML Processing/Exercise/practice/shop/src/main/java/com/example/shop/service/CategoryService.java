package com.example.shop.service;

import com.example.shop.model.dto.view.ThirdQuery.CategoriesRootViewDto;
import com.example.shop.model.entity.Category;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public interface CategoryService {

  void seedCategories() throws JAXBException, FileNotFoundException;

  List<Category> getRandomCategories();

  CategoriesRootViewDto findAllCategoriesByProductsCount();
}
