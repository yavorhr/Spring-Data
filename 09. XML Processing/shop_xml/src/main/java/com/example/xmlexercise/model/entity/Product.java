package com.example.xmlexercise.model.entity;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{

    private String name;
    private BigDecimal price;
    private User seller;
    private User buyer;

    private List<Category> categories;


    public Product() {
    }

    @Column
    public String getName() {
        return name;
    }
    @Column
    public BigDecimal getPrice() {
        return price;
    }

    @ManyToOne
    public User getSeller() {
        return seller;
    }

    @ManyToOne
    public User getBuyer() {
        return buyer;
    }

    @ManyToMany
    public List<Category> getCategories() {
        return categories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
