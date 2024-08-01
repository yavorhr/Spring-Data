package com.example.cardealer_practice.model.service.impl;

import com.example.cardealer_practice.model.repository.SaleRepository;
import com.example.cardealer_practice.model.service.SaleService;
import com.example.cardealer_practice.model.util.ValidationUtil;
import com.google.gson.Gson;;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {
  private final SaleRepository saleRepository;
  private final ModelMapper modelMapper;
  private final Gson gson;
  private final ValidationUtil validationUtil;

  public SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
    this.saleRepository = saleRepository;
    this.modelMapper = modelMapper;
    this.gson = gson;
    this.validationUtil = validationUtil;
  }

  @Override
  public void seedSales() {

  }
}
