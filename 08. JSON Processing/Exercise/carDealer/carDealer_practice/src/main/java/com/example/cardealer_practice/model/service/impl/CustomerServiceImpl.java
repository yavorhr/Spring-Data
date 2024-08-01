package com.example.cardealer_practice.model.service.impl;

import com.example.cardealer_practice.constant.ProjectConstants;
import com.example.cardealer_practice.model.entity.Customer;
import com.example.cardealer_practice.model.entity.dto.seed.CustomerDto;
import com.example.cardealer_practice.model.repository.CustomerRepository;
import com.example.cardealer_practice.model.service.CustomerService;
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
    if (this.customerRepository.count() > 1) {
      return;
    }

    String customersJson = Files.readString(Path.of(ProjectConstants.CUSTOMERS_INPUT_PATH));
    CustomerDto[] customerDtos = this.gson.fromJson(customersJson, CustomerDto[].class);

    Arrays.stream(customerDtos)
            .filter(validationUtil::isValid)
            .map(dto -> this.modelMapper.map(dto, Customer.class))
            .forEach(this.customerRepository::save);
  }

  @Override
  public Customer findRandomCustomer() {
    long randomId = ThreadLocalRandom.current().nextLong(1, this.customerRepository.count() + 1);
    return this.customerRepository.findById(randomId).orElse(null);
  }
}
