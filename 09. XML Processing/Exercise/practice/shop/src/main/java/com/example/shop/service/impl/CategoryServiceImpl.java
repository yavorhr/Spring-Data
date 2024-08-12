package com.example.shop.service.impl;

import com.example.shop.constant.ProjectConstants;
import com.example.shop.model.dto.seed.CategorySeedRootDto;
import com.example.shop.repository.CategoryRepository;
import com.example.shop.service.CategoryService;
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

  public CategoryServiceImpl(ModelMapper modelMapper, CategoryRepository categoryRepository, XmlParser xmlParser) {
    this.modelMapper = modelMapper;
    this.categoryRepository = categoryRepository;
    this.xmlParser = xmlParser;
  }

  @Override
  public void seedCategories() throws JAXBException, FileNotFoundException {
    if (this.categoryRepository.count() > 0) {
      return;
    }
    xmlParser.fromFile(ProjectConstants.SEED_CATEGORIES_PATH, CategorySeedRootDto.class);
  }
}
