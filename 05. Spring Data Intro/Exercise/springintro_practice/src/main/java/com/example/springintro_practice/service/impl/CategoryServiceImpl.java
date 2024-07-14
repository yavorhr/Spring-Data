package com.example.springintro_practice.service.impl;

import com.example.springintro_practice.common.FilePath;
import com.example.springintro_practice.model.Category;
import com.example.springintro_practice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CategoryServiceImpl implements CategoryService {


  @Override
  public void seedCategories() throws IOException {



  }
}
