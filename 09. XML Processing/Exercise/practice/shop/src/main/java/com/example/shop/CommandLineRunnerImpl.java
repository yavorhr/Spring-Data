package com.example.shop;

import com.example.shop.constant.ProjectConstants;
import com.example.shop.model.dto.view.FirstQuery.ProductsViewRootDto;
import com.example.shop.service.CategoryService;
import com.example.shop.service.ProductService;
import com.example.shop.service.UserService;
import com.example.shop.util.XmlParser;
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
  private final XmlParser xmlParser;

  public CommandLineRunnerImpl(BufferedReader bufferedReader, CategoryService categoryService, UserService userService, ProductService productService, XmlParser xmlParser) {
    this.bufferedReader = bufferedReader;
    this.categoryService = categoryService;
    this.userService = userService;
    this.productService = productService;
    this.xmlParser = xmlParser;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();

    System.out.println("Please select task: ");
    int task = Integer.parseInt(this.bufferedReader.readLine());
    switch (task) {
      case 1 -> productsInRange();
    }
  }

  private void productsInRange() throws JAXBException {
    ProductsViewRootDto rootDto = this.productService.findProductsInRangeWithoutBuyer();
    this.xmlParser.writeToFile(ProjectConstants.FIRST_QUERY, rootDto);
  }

  private void seedData() throws JAXBException, FileNotFoundException {
    this.categoryService.seedCategories();
    this.userService.seedUsers();
    this.productService.seedProducts();
  }
}
