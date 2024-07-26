package com.example.jsonexercie.service.Impl;

import com.example.jsonexercie.model.Dto.CategorySeedDto;
import com.example.jsonexercie.model.Entity.Category;
import com.example.jsonexercie.repository.CategoryRepository;
import com.example.jsonexercie.service.CategoryService;
import com.example.jsonexercie.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.jsonexercie.constant.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_NAME = "categories.json";
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }

        String content = Files
                .readString(Path.of(RESOURCES_FILE_PATH + CATEGORIES_FILE_NAME));
        CategorySeedDto[] categorySeedDtos = gson.fromJson(content, CategorySeedDto[].class);
        Arrays.stream(categorySeedDtos)
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(this.categoryRepository::save);

    }

    @Override
    public Set<Category> findRandomCategories() {

        int categoryCount = ThreadLocalRandom.current().nextInt(1, 3);

        Set<Category> categoriesSet = new HashSet<>();
        long allCategories = categoryRepository.count();

        for (int i = 0; i < categoryCount; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, allCategories + 1);
            categoriesSet.add(categoryRepository.findById(randomId).orElse(null));
        }

        return categoriesSet;
    }
}
