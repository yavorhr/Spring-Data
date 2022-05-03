package com.example.jsonexercie.service;


import com.example.jsonexercie.model.Entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> findRandomCategories();
}
