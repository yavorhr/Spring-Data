package com.example.shop.service.impl;

import com.example.shop.service.CategoryService;
import com.example.shop.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
  private final ModelMapper modelMapper;
  private final XmlParser xmlParser;

  public CategoryServiceImpl(ModelMapper modelMapper, XmlParser xmlParser) {
    this.modelMapper = modelMapper;
    this.xmlParser = xmlParser;
  }

  @Override
  public void seedCategories() {

  }
}
