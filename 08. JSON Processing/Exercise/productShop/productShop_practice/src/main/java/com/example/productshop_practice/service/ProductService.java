package com.example.productshop_practice.service;

import com.example.productshop_practice.model.dto.view.firstQuery.ProductWithNamePriceAndSellerNameDto;

import java.io.IOException;
import java.util.List;

public interface ProductService {
  void seedProducts() throws IOException;

  List<ProductWithNamePriceAndSellerNameDto> findAllUsersWithMoreThanOneSoldProducts();
}
