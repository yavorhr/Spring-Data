package com.example.jsonexercie.repository;

import com.example.jsonexercie.model.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category,Long> {
}
