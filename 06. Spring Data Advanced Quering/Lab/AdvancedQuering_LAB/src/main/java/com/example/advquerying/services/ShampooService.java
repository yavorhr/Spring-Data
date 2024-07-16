package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ShampooService {

  List<String> findAllShampoosBySize(String size);

  List<String> findAllShampoosBySizeOrLabel(Size medium, long labelId);

  List<String> findAllShampoosByPrice(BigDecimal price);

  long countShampoosByPriceLowerThenGiven(BigDecimal price);

  Set<String> findAllByIngredients(List<String> ingredients);

  Set<String> findAllShampoosByIngredientsCountLessThanGiven(long count);
}
