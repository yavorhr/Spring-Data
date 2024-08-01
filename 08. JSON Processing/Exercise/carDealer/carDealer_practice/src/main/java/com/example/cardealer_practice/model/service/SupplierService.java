package com.example.cardealer_practice.model.service;

import com.example.cardealer_practice.model.entity.Supplier;
import com.example.cardealer_practice.model.entity.dto.view.SupplierVewDto;

import java.io.IOException;
import java.util.List;

public interface SupplierService {
  void seedSuppliers() throws IOException;

  Supplier findRandomSupplier();

  List<SupplierVewDto> findLocalSuppliers();
}
