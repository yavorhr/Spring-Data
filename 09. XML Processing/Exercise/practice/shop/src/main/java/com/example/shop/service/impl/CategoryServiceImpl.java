package com.example.shop.service.impl;

import com.example.shop.constant.ProjectConstants;
import com.example.shop.model.dto.seed.CategorySeedRootDto;
import com.example.shop.model.entity.Category;
import com.example.shop.repository.CategoryRepository;
import com.example.shop.service.CategoryService;
import com.example.shop.util.ValidationUtil;
import com.example.shop.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

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
            xmlParser.fromFile(ProjectConstants.SEED_CATEGORIES_PATH, CategorySeedRootDto.class);
    categorySeedRootDto.getCategories()
            .stream()
            .filter(this.validationUtil::isValid)
            .map(dto -> this.modelMapper.map(dto, Category.class))
            .forEach(this.categoryRepository::save);
  }
}
