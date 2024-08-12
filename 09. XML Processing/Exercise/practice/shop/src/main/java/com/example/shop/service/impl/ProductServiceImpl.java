package com.example.shop.service.impl;

import com.example.shop.constant.ProjectConstants;
import com.example.shop.model.dto.seed.ProductSeedRootDto;
import com.example.shop.model.entity.Product;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.CategoryService;
import com.example.shop.service.ProductService;
import com.example.shop.service.UserService;
import com.example.shop.util.ValidationUtil;
import com.example.shop.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {
  private final ModelMapper modelMapper;
  private final ProductRepository productRepository;
  private final XmlParser xmlParser;
  private final ValidationUtil validationUtil;
  private final UserService userService;
  private final CategoryService categoryService;

  public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository, XmlParser xmlParser, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
    this.modelMapper = modelMapper;
    this.productRepository = productRepository;
    this.xmlParser = xmlParser;
    this.validationUtil = validationUtil;
    this.userService = userService;
    this.categoryService = categoryService;
  }

  @Override
  public void seedProducts() throws JAXBException, FileNotFoundException {
    if (productRepository.count() > 0) {
      return;
    }

    ProductSeedRootDto productSeedRootDto =
            this.xmlParser.fromFile(ProjectConstants.SEED_PRODUCTS, ProductSeedRootDto.class);

    productSeedRootDto.getProducts()
            .stream()
            .filter(this.validationUtil::isValid)
            .map(dto -> {
              Product product = this.modelMapper.map(dto, Product.class);

              product.setSeller(userService.getRandomUser());
              product.setCategories(categoryService.getRandomCategories());

              if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
                product.setBuyer(userService.getRandomUser());
              }
              return product;
            })
            .forEach(this.productRepository::save);
  }
}
