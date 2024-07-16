package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

  List<Ingredient> findAllByNameStartingWith(String name);

  List<Ingredient> findAllByNameInOrderByPriceAsc(Collection<String> name);

  @Query("DELETE FROM Ingredient i WHERE i.name = :name")
  @Modifying
  void deleteIngredientByName(String name);

  @Query("UPDATE Ingredient i SET i.price = i.price *1.10")
  @Modifying
  int increaseIngredientPriceBy10Percent();

  @Query("UPDATE Ingredient i SET i.price = i.price * :multiplier WHERE i.name IN :names")
  @Modifying
  int increaseSelectedIngredientsPrices(BigDecimal multiplier, List<String> names);
}
