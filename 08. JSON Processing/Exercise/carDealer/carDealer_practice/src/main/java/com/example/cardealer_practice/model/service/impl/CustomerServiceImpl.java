package com.example.cardealer_practice.model.service.impl;

import com.example.cardealer_practice.constant.ProjectConstants;
import com.example.cardealer_practice.model.repository.CustomerRepository;
import com.example.cardealer_practice.model.service.CustomerService;
import com.example.cardealer_practice.model.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CustomerServiceImpl implements CustomerService {
  private final CustomerRepository customerRepository;
  private final ModelMapper modelMapper;
  private final Gson gson;
  private final ValidationUtil validationUtil;

  public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
    this.customerRepository = customerRepository;
    this.modelMapper = modelMapper;
    this.gson = gson;
    this.validationUtil = validationUtil;
  }

  @Override
  public void seedCustomers() throws IOException {
    String customersJson = Files.readString(Path.of(ProjectConstants.CUSTOMERS_INPUT_PATH));

  }
}
