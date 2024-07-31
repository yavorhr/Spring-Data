package com.example.cardealer_practice.model.service.impl;

import com.example.cardealer_practice.constant.ProjectConstants;
import com.example.cardealer_practice.model.entity.Supplier;
import com.example.cardealer_practice.model.entity.dto.seed.SupplierDto;
import com.example.cardealer_practice.model.repository.SupplierRepository;
import com.example.cardealer_practice.model.service.SupplierService;
import com.example.cardealer_practice.model.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SupplerServiceImpl implements SupplierService {
  private final SupplierRepository supplierRepository;
  private final ModelMapper modelMapper;
  private final Gson gson;
  private final ValidationUtil validationUtil;

  public SupplerServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
    this.supplierRepository = supplierRepository;
    this.modelMapper = modelMapper;
    this.gson = gson;
    this.validationUtil = validationUtil;
  }

  @Override
  public void seedSuppliers() throws IOException {
    if (this.supplierRepository.count() == 0) {
      String suppliersJson = Files.readString(Path.of(ProjectConstants.SUPPLIERS_INPUT_PATH));

      SupplierDto[] dtos = this.gson.fromJson(suppliersJson, SupplierDto[].class);

      Arrays.stream(dtos)
              .filter(validationUtil::isValid)
              .map(d -> this.modelMapper.map(d, Supplier.class))
              .forEach(this.supplierRepository::save);
    }
  }

  @Override
  public Supplier findRandomSupplier() {
    long randomId = ThreadLocalRandom.current().nextLong(1, this.supplierRepository.count()+1);
    return this.supplierRepository.findById(randomId).orElse(null);
  }
}
