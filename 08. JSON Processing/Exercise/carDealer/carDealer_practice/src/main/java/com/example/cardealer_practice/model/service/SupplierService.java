package com.example.cardealer_practice.model.service;

import com.example.cardealer_practice.model.entity.Supplier;

import java.io.IOException;

public interface SupplierService {
  void seedSuppliers() throws IOException;

  Supplier findRandomSupplier();
}
