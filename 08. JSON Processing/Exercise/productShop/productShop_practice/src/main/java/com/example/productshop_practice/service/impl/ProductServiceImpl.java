package com.example.productshop_practice.service.impl;

import com.example.productshop_practice.constant.GlobalConstants;
import com.example.productshop_practice.model.dto.ProductSeedDto;
import com.example.productshop_practice.model.dto.view.ProductDtoWithNamePriceAndSellerName;
import com.example.productshop_practice.model.entity.Product;
import com.example.productshop_practice.repository.ProductRepository;
import com.example.productshop_practice.service.CategoryService;
import com.example.productshop_practice.service.ProductService;
import com.example.productshop_practice.service.UserService;
import com.example.productshop_practice.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService {
  private final Gson gson;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final ProductRepository productRepository;
  private final UserService userService;
  private final CategoryService categoryService;

  public ProductServiceImpl(Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, ProductRepository productRepository, UserService userService, CategoryService categoryService) {
    this.gson = gson;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.productRepository = productRepository;
    this.userService = userService;
    this.categoryService = categoryService;
  }

  @Override
  public void seedProducts() throws IOException {
    if (productRepository.count() == 0) {
      String productsJson = Files.readString(Path.of(GlobalConstants.SEED_PRODUCTS_PATH));

      ProductSeedDto[] productSeedDtos = this.gson.fromJson(productsJson, ProductSeedDto[].class);
      Arrays.stream(productSeedDtos)
              .filter(validationUtil::isValid)
              .map(dto -> {
                Product product = this.modelMapper.map(dto, Product.class);

                product.setSeller(this.userService.findRandomUser());

                if (product.getPrice().compareTo(BigDecimal.valueOf(900)) > 0) {
                  product.setBuyer(userService.findRandomUser());
                }

                product.setCategories(this.categoryService.findRandomCategories());

                return product;
              })
              .forEach(productRepository::save);
    }
  }

  @Override
  public List<ProductDtoWithNamePriceAndSellerName> findAllUsersWithMoreThanOneSoldProducts() {
    List<Product> products = this.productRepository
            .findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

   return  products
            .stream()
            .map(product -> {
              ProductDtoWithNamePriceAndSellerName dto =
                      this.modelMapper.map(product, ProductDtoWithNamePriceAndSellerName.class);

              dto.setSeller(String.format("%s %s"
                      ,product.getSeller().getFirstName()
                      ,product.getSeller().getLastName()));

              return dto;
            })
            .collect(Collectors.toList());

  }
}
