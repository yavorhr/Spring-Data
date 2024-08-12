package com.example.shop;

import com.example.shop.service.CategoryService;
import com.example.shop.service.ProductService;
import com.example.shop.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

@Service
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final BufferedReader bufferedReader;
  private final CategoryService categoryService;
  private final UserService userService;
  private final ProductService productService;

  public CommandLineRunnerImpl(BufferedReader bufferedReader, CategoryService categoryService, UserService userService, ProductService productService) {
    this.bufferedReader = bufferedReader;
    this.categoryService = categoryService;
    this.userService = userService;
    this.productService = productService;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();
  }

  private void seedData() throws JAXBException, FileNotFoundException {
    this.categoryService.seedCategories();
    this.userService.seedUsers();
    this.productService.seedProducts();
  }
}
