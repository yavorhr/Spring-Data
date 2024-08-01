package com.example.cardealer_practice.model.service;

import com.example.cardealer_practice.model.entity.Customer;
import com.example.cardealer_practice.model.entity.dto.view.CustomerBoughtCarsViewDto;
import com.example.cardealer_practice.model.entity.dto.view.CustomerViewDto;

import java.io.IOException;
import java.util.List;

public interface CustomerService {
  void seedCustomers() throws IOException;

  Customer findRandomCustomer();

  List<CustomerViewDto> findCustomersOrderByBirthDateAscYoungDriverAsc();

  List<CustomerBoughtCarsViewDto> findCustomersByTopSales();

}
