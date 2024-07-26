package com.example.productshop_practice.repository;
import com.example.productshop_practice.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Category, Long> {
}
