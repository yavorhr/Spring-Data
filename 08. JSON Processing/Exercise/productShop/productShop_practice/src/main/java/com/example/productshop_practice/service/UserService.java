package com.example.productshop_practice.service;

import com.example.productshop_practice.model.dto.view.secondQuery.SellerWithSoldProductsDto;
import com.example.productshop_practice.model.dto.view.fourthQuery.SellersCountAndSellersSoldProductsDataDto;
import com.example.productshop_practice.model.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
  void seedUsers() throws IOException;

  User findRandomUser();

  List<SellerWithSoldProductsDto> findAllUsersWithMoreThanOneSoldProducts();

  SellersCountAndSellersSoldProductsDataDto findAllUsersCountWithMoreThanOneSoldProducts();
}
