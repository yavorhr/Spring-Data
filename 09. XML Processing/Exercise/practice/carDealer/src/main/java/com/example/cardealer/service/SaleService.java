package com.example.cardealer.service;

import com.example.cardealer.model.dto.view.SixthQuery.SalesAppDiscRootViewDto;

public interface SaleService {
  void seedSales();

  SalesAppDiscRootViewDto findAllSales();
}
