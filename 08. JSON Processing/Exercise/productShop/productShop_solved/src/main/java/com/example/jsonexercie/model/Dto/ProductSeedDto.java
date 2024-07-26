package com.example.jsonexercie.model.Dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductSeedDto {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    public ProductSeedDto() {
    }

    @Size(min = 3)
    public String getName() {
        return name;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
