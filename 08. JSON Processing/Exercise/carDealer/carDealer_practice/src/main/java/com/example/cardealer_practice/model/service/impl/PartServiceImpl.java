package com.example.cardealer_practice.model.service.impl;

import com.example.cardealer_practice.constant.ProjectConstants;
import com.example.cardealer_practice.model.entity.Part;
import com.example.cardealer_practice.model.entity.dto.seed.PartDto;
import com.example.cardealer_practice.model.repository.PartRepository;
import com.example.cardealer_practice.model.service.PartService;
import com.example.cardealer_practice.model.service.SupplierService;
import com.example.cardealer_practice.model.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {
  private final PartRepository partRepository;
  private final ModelMapper modelMapper;
  private final Gson gson;
  private final ValidationUtil validationUtil;
  private final SupplierService supplierService;

  public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, SupplierService supplierService) {
    this.partRepository = partRepository;
    this.modelMapper = modelMapper;
    this.gson = gson;
    this.validationUtil = validationUtil;
    this.supplierService = supplierService;
  }

  @Override
  public void seedParts() throws IOException {
    if (this.partRepository.count() == 0) {
      String partsJson = Files.readString(Path.of(ProjectConstants.PARTS_INPUT_PATH));
      PartDto[] partsDtos = this.gson.fromJson(partsJson, PartDto[].class);

      Arrays.stream(partsDtos)
              .filter(this.validationUtil::isValid)
              .map(dto -> {
                Part part = this.modelMapper.map(dto, Part.class);
                part.setSupplier(this.supplierService.findRandomSupplier());

                return part;
              })
              .forEach((this.partRepository::save));
    }
  }

  @Override
  public Set<Part> findRandomParts() {
    long randomCountPartsToBeAdded = ThreadLocalRandom.current().nextLong(3, 5);
    long repositorySize = this.partRepository.count();

    Set<Part> randomParts = new HashSet<>();

    for (int i = 0; i < randomCountPartsToBeAdded; i++) {
      long randomId = ThreadLocalRandom.current().nextLong(1, repositorySize + 1);
      Part part = this.partRepository.findById(randomId).orElse(null);
      randomParts.add(part);
    }

    return randomParts;
  }
}
