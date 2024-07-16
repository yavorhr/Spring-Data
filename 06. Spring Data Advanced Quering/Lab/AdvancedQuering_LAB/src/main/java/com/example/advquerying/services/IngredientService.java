package com.example.advquerying.services;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientService {
  List<String> findAllIngredientsByFirstLetters(String letters);

  List<String> findAllIngredientsFromList(List<String> ingredientsList);

  void removeIngredientByName(String name);

  int increaseIngredientsPriceBy10percent();

  int increaseSelectedIngredientsByMultiplier(BigDecimal multiplier, List<String> ingredients);
}
