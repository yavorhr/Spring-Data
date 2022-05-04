package com.example.xmlexercise.service.impl;

import com.example.xmlexercise.model.dto.Shop_query3.CategoryRootDto;
import com.example.xmlexercise.model.dto.Shop_SeedDtos.CategorySeedDto;
import com.example.xmlexercise.model.dto.Shop_query3.CategoryWithProductDetailsDto;
import com.example.xmlexercise.model.entity.Category;
import com.example.xmlexercise.repository.CategoryRepository;
import com.example.xmlexercise.repository.ProductRepository;
import com.example.xmlexercise.service.CategoryService;
import com.example.xmlexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final ProductRepository productRepository;


    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.productRepository = productRepository;
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {

        categories
                .stream()
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .filter(validationUtil::isValid)
                .forEach(categoryRepository::save);
    }

    @Override
    public long getEntityCount() {
        return this.categoryRepository.count();
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
    @SuppressWarnings("double value exist")
    public CategoryRootDto getCategoriesOrderedByProductsCountPlusAvgPrice() {
        CategoryRootDto categoryRootDto = new CategoryRootDto();
        List<CategoryWithProductDetailsDto> categoriesDto = new ArrayList<>();

        List<Category> categories = categoryRepository.findAll();

        for (Category category : categories) {
            CategoryWithProductDetailsDto currentCategoryDto = new CategoryWithProductDetailsDto();
            //name
            currentCategoryDto.setName(category.getName());
            //products-count
            currentCategoryDto.setProductsCount(category.getProducts().size());
            //average-price

            currentCategoryDto.setAveragePrice(
                    category.getProducts()
                            .stream()
                            .mapToDouble(product -> product.getPrice().doubleValue())
                            .average()
                            .getAsDouble());

            //totalRevenue
            double totalSum = category.getProducts()
                    .stream()
                    .mapToDouble(product -> product.getPrice().doubleValue())
                    .sum();
            currentCategoryDto.setTotalRevenue(totalSum);

            categoriesDto.add(currentCategoryDto);
        }

        categoriesDto.sort((c1, c2) -> Integer.compare(c2.getProductsCount(),c1.getProductsCount()));
        categoryRootDto.setCategories(categoriesDto);
        return categoryRootDto;
    }
}

