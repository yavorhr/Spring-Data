package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

  List<Ingredient> findAllByNameStartingWith(String name);

  List<Ingredient> findAllByNameInOrderByPriceAsc(Collection<String> name);
}
