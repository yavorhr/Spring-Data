package com.example.jsonexercie.service.Impl;

import com.example.jsonexercie.model.Dto.ProductNameAndPriceDto;
import com.example.jsonexercie.model.Dto.ProductSeedDto;
import com.example.jsonexercie.model.Entity.Category;
import com.example.jsonexercie.model.Entity.Product;
import com.example.jsonexercie.model.Entity.User;
import com.example.jsonexercie.repository.ProductRepository;
import com.example.jsonexercie.service.CategoryService;
import com.example.jsonexercie.service.ProductService;
import com.example.jsonexercie.service.UserService;
import com.example.jsonexercie.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.jsonexercie.constant.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private static final String PRODUCTS_FILE_NAME = "products.json";
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts() throws IOException {
        if (productRepository.count() > 0) {
            return;
        }

        String productsContent = Files.readString(Path.of(RESOURCES_FILE_PATH + PRODUCTS_FILE_NAME));

        ProductSeedDto[] productSeedDtos = gson.fromJson(productsContent, ProductSeedDto[].class);

        Arrays.stream(productSeedDtos)
                .filter((validationUtil::isValid))
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);
                    product.setSeller(userService.findRandomUser());

                    if (product.getPrice().compareTo(BigDecimal.valueOf(900)) > 0) {
                        product.setBuyer(userService.findRandomUser());
                    }
                    product.setCategories(categoryService.findRandomCategories());

                    return product;
                })
                .forEach(productRepository::save);
    }

    @Override
    public List<ProductNameAndPriceDto> findAllProductsInRangeOrderByPrice(BigDecimal lower, BigDecimal upper) {
        return productRepository.findAllByPriceBetweenAndBuyerIsNull(lower, upper)
                .stream()
                .map(product -> {
                    ProductNameAndPriceDto productNameAndPriceDto = modelMapper.map(product,ProductNameAndPriceDto.class);

                    productNameAndPriceDto.setSeller(String.format("%s %s",product.getSeller().getFirstName(),product.getSeller().getLastName()));

                    return productNameAndPriceDto;
                })
                .collect(Collectors.toList());
    }
}
