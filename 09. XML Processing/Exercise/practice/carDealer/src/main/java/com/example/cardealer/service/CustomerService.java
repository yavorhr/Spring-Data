package com.example.cardealer.service;

import com.example.cardealer.model.dto.view.FifthQuery.CustomersWithTotalSalesRootViewDto;
import com.example.cardealer.model.dto.view.FirstQuery.CustomersRootViewDto;
import com.example.cardealer.model.entity.Customer;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CustomerService {

  void seedCustomers() throws JAXBException, FileNotFoundException;

  Customer findRandomCustomer();

  CustomersRootViewDto findAllCustomersOrderedByBdayAscAndYoungDrivers();

  CustomersWithTotalSalesRootViewDto findAllCustomersWithAtLeastOneBoughtCar();
}
