package com.example.advquerying.services.impl;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.services.ShampooService;
import org.springframework.stereotype.Service;

import java.util.List;
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

    return shampoos.stream().map(Shampoo::getBrand).collect(Collectors.toList());
  }
}
