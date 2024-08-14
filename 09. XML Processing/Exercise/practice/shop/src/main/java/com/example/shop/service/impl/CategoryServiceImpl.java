package com.example.shop.service.impl;

import com.example.shop.constant.ProjectConstants;
import com.example.shop.model.dto.seed.CategorySeedRootDto;
import com.example.shop.model.dto.view.ThirdQuery.CategoriesRootViewDto;
import com.example.shop.model.dto.view.ThirdQuery.CategoryViewDto;
import com.example.shop.model.entity.Category;
import com.example.shop.model.entity.Product;
import com.example.shop.repository.CategoryRepository;
import com.example.shop.service.CategoryService;
import com.example.shop.util.ValidationUtil;
import com.example.shop.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
  private final ModelMapper modelMapper;
  private final CategoryRepository categoryRepository;
  private final XmlParser xmlParser;
  private final ValidationUtil validationUtil;

  public CategoryServiceImpl(ModelMapper modelMapper, CategoryRepository categoryRepository, XmlParser xmlParser, ValidationUtil validationUtil) {
    this.modelMapper = modelMapper;
    this.categoryRepository = categoryRepository;
    this.xmlParser = xmlParser;
    this.validationUtil = validationUtil;
  }

  @Override
  public void seedCategories() throws JAXBException, FileNotFoundException {
    if (this.categoryRepository.count() > 0) {
      return;
    }

    CategorySeedRootDto categorySeedRootDto =
            xmlParser.fromFile(ProjectConstants.SEED_CATEGORIES, CategorySeedRootDto.class);
    categorySeedRootDto.getCategories()
            .stream()
            .filter(this.validationUtil::isValid)
            .map(dto -> this.modelMapper.map(dto, Category.class))
            .forEach(this.categoryRepository::save);
  }

  @Override
  public List<Category> getRandomCategories() {
    List<Category> categories = new ArrayList<>();

    int randomCount = ThreadLocalRandom.current().nextInt(1, 3);
    long count = categoryRepository.count();

    for (int i = 0; i < randomCount; i++) {
      long randomId = ThreadLocalRandom.current().nextLong(1, count + 1);
      Category category = categoryRepository.findById(randomId).orElse(null);
      categories.add(category);
    }

    return categories;
  }

  @Override
  public CategoriesRootViewDto findAllCategoriesByProductsCount() {
    List<CategoryViewDto> innerDtos =
            this.categoryRepository
                    .findAll()
                    .stream()
                    .map(e -> {
                      var categoryViewDto = new CategoryViewDto();
                      categoryViewDto.setName(e.getName());
                      categoryViewDto.setProductsCount(e.getProducts().size());

                      double avgPrice = e.getProducts().stream().mapToDouble(p -> p.getPrice().doubleValue()).average().getAsDouble();
                      categoryViewDto.setAveragePrice(avgPrice);

                      double totalRevenue = e.getProducts().stream().mapToDouble(p -> p.getPrice().doubleValue()).sum();
                      categoryViewDto.setTotalRevenue(totalRevenue);
                      return categoryViewDto;
                    })
                    .sorted((c1, c2) -> Integer.compare(c2.getProductsCount(), c1.getProductsCount()))
                    .collect(Collectors.toList());

    CategoriesRootViewDto rootDto = new CategoriesRootViewDto();
    rootDto.setCategories(innerDtos);

    return rootDto;
  }
}
