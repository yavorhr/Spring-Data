package com.example.cardealer_practice.model.service;

import com.example.cardealer_practice.model.entity.Part;

import java.io.IOException;
import java.util.Set;

public interface PartService {
  void seedParts() throws IOException;

  Set<Part> findRandomParts();
}
