package com.example.xmlexercise.service.impl;

import com.example.xmlexercise.model.dto.Shop_SeedDtos.ProductSeedDto;
import com.example.xmlexercise.model.dto.Shop_query1.ProductViewRootDto;
import com.example.xmlexercise.model.entity.Product;
import com.example.xmlexercise.repository.ProductRepository;
import com.example.xmlexercise.service.CategoryService;
import com.example.xmlexercise.service.ProductService;
import com.example.xmlexercise.service.UserService;
import com.example.xmlexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public Long getCount() {
        return productRepository.count();
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        products
                .stream()
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {

                    Product product = modelMapper.map(productSeedDto, Product.class);
                    product.setSeller(userService.getRandomUser());

                    if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
                        product.setBuyer(userService.getRandomUser());
                    }

                    product.setCategories(categoryService.getRandomCategories());

                    return product;
                })
                .forEach(productRepository::save);
    }

    @Override
    public ProductViewRootDto findProductsInRangeWithoutBuyer() {
        ProductViewRootDto rootDto = new ProductViewRootDto();

        rootDto
                .setProducts(productRepository.findAllByPriceBetweenAndBuyerIsNull(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L))
                        .stream()
                        .map(product -> {
                            ProductViewRootDto.ProductWithSellerDto productWithSellerDto = modelMapper.map(product, ProductViewRootDto.ProductWithSellerDto.class);
                            productWithSellerDto.setSeller(String.format("%s %s",
                                    product.getSeller().getFirstName(),
                                    product.getSeller().getLastName()));
                            return productWithSellerDto;
                        })
                        .collect(Collectors.toList())
                );

        return rootDto;
    }
}
