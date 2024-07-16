package com.example.advquerying.services.impl;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.services.ShampooService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {
  private final ShampooRepository shampooRepository;

  public ShampooServiceImpl(ShampooRepository shampooRepository) {
    this.shampooRepository = shampooRepository;
  }

  @Override
  public List<String> findAllShampoosBySize(String size) {

    List<Shampoo> shampoos =
            this.shampooRepository.findAllBySizeOrderById(Size.valueOf(size));

    return shampoos
            .stream()
            .map(Shampoo::getBrand)
            .collect(Collectors.toList());
  }

  @Override
  public List<String> findAllShampoosBySizeOrLabel(Size size, long labelId) {
    List<Shampoo> shampoos =
            this.shampooRepository
                    .findAllBySizeOrLabelIdOrderByPriceAsc(size, labelId);

    return shampoos
            .stream()
            .map(Shampoo::getBrand)
            .collect(Collectors.toList());
  }

  @Override
  public List<String> findAllShampoosByPrice(BigDecimal price) {
    List<Shampoo> shampoos =
            this.shampooRepository
                    .findAllByPriceGreaterThanOrderByPriceDesc(price);

    return shampoos
            .stream()
            .map(Shampoo::getBrand)
            .collect(Collectors.toList());
  }

  @Override
  public long countShampoosByPriceLowerThenGiven(BigDecimal price) {
    return this.shampooRepository.countAllByPriceIsLessThan(price);
  }

  @Override
  public Set<String> findAllByIngredients(List<String> ingredients) {
    List<Shampoo> allByIngredients = this.shampooRepository.findAllByIngredients(ingredients);

    return allByIngredients
            .stream()
            .map(Shampoo::getBrand)
            .collect(Collectors.toSet());


  }

  @Override
  public Set<String> findAllShampoosByIngredientsCountLessThanGiven(long count) {
    List<Shampoo> allByIngredientsLassThan = this.shampooRepository.findAllByIngredientsLassThan(count);

    return allByIngredientsLassThan
            .stream()
            .map(Shampoo::getBrand)
            .collect(Collectors.toSet());
  }
}
