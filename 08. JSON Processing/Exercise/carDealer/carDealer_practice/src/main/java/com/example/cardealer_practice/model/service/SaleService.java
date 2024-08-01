package com.example.cardealer_practice.model.service;

import com.example.cardealer_practice.model.entity.dto.view.fifthQuery.CustomerWithPricesViewDto;

import java.util.List;

public interface SaleService {
  void seedSales();

  List<CustomerWithPricesViewDto> findSalesWithAppliedDiscounts();
}
