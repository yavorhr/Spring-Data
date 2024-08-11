package com.example.shop.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private String name;
    private List<Product> products;

    public Category() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Column(length = 15,nullable = false,unique = true)
    public String getName() {
        return name;
    }

    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setName(String name) {
        this.name = name;
    }
}
