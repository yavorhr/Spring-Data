package com.example.cardealer_practice.model.service;

import com.example.cardealer_practice.model.entity.Customer;

import java.io.IOException;

public interface CustomerService {
  void seedCustomers() throws IOException;

  Customer findRandomCustomer();
}
