package com.example.cardealer.service.impl;

import com.example.cardealer.repository.SaleRepository;
import com.example.cardealer.service.CarService;
import com.example.cardealer.service.CustomerService;
import com.example.cardealer.service.SaleService;
import com.example.cardealer.util.ValidationUtil;
import com.example.cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {
  private final SaleRepository saleRepository;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final XmlParser xmlParser;
  private final CarService carService;
  private final CustomerService customerService;

  public SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, CarService carService, CustomerService customerService) {
    this.saleRepository = saleRepository;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.xmlParser = xmlParser;
    this.carService = carService;
    this.customerService = customerService;
  }

  @Override
  public void seedSales() {

  }
}
