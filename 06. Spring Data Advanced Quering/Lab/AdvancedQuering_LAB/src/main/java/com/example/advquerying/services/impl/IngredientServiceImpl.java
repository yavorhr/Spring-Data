package com.example.advquerying.services.impl;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import com.example.advquerying.services.IngredientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
  private final IngredientRepository ingredientRepository;

  public IngredientServiceImpl(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  @Override
  public List<String> findAllIngredientsByFirstLetters(String letters) {
    List<Ingredient> allByNameStartingWith =
            this.ingredientRepository.findAllByNameStartingWith(letters);

    return allByNameStartingWith
            .stream()
            .map(Ingredient::getName)
            .collect(Collectors.toList());
  }

  @Override
  public List<String> findAllIngredientsFromList(List<String> ingredientsList) {
    List<Ingredient> allByNameFromList =
            this.ingredientRepository.findAllByNameInOrderByPriceAsc(ingredientsList);

    return allByNameFromList
            .stream()
            .map(Ingredient::getName)
            .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public void removeIngredientByName(String name) {
    this.ingredientRepository.deleteIngredientByName(name);
  }
}
