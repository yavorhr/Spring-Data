package com.example.xmlexercise.service;

import com.example.xmlexercise.model.dto.Shop_SeedDtos.ProductSeedDto;
import com.example.xmlexercise.model.dto.Shop_query1.ProductViewRootDto;

import java.util.List;

public interface ProductService {
    Long getCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductViewRootDto findProductsInRangeWithoutBuyer();
}
