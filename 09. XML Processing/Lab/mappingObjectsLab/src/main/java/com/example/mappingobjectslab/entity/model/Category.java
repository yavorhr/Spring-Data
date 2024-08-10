package com.example.mappingobjectslab.entity.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Category {
    private Long id;
    private String name;
    private Set<Product> products;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "categories")
    public Set<Product> getProducts() {
        // product.setCategories(categories);
        // repo.save(product)
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
