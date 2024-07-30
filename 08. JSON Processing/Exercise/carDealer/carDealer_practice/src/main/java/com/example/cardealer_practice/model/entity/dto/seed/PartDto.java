package com.example.cardealer_practice.model.entity.dto.seed;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class PartDto {
  @Expose
  @Size(min = 1)
  private String name;
  @Expose
  @Positive
  private BigDecimal price;
  @Positive
  @Expose
  private int quantity;

  public PartDto() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
