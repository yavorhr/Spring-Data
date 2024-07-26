package com.example.jsonexercie.model.Dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserSoldDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;

    @Expose
    private Set<ProductWithBuyerDto> soldProducts;

    public UserSoldDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<ProductWithBuyerDto> getSoldProducts() {
        return soldProducts;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSoldProducts(Set<ProductWithBuyerDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
