package com.example.advquerying.services;

import java.util.List;

public interface IngredientService {
  List<String> findAllIngredientsByFirstLetters(String letters);

  List<String> findAllIngredientsFromList(List<String> ingredientsList);

  void removeIngredientByName(String name);

}
