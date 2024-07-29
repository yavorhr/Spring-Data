package com.example.productshop_practice.model.dto.view.fourthQuery;
import com.google.gson.annotations.Expose;

import java.util.List;

public class ProductsCountAndDataDto {
  @Expose
  private long count;
  @Expose
  private List<ProductDto> products;

  public ProductsCountAndDataDto() {
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public List<ProductDto> getProducts() {
    return products;
  }

  public void setProducts(List<ProductDto> products) {
    this.products = products;
  }
}
