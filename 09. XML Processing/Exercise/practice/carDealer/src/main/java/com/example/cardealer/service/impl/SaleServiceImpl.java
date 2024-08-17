package com.example.cardealer.service.impl;

import com.example.cardealer.model.entity.Car;
import com.example.cardealer.model.entity.Customer;
import com.example.cardealer.model.entity.Sale;
import com.example.cardealer.repository.SaleRepository;
import com.example.cardealer.service.CarService;
import com.example.cardealer.service.CustomerService;
import com.example.cardealer.service.SaleService;
import com.example.cardealer.util.ValidationUtil;
import com.example.cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
  private final SaleRepository saleRepository;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final CarService carService;
  private final CustomerService customerService;

  public SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper, ValidationUtil validationUtil, CarService carService, CustomerService customerService) {
    this.saleRepository = saleRepository;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.carService = carService;
    this.customerService = customerService;
  }

  @Override
  public void seedSales() {
    if (this.saleRepository.count() > 0) {
      return;
    }

    for (int i = 0; i < 30; i++) {
      Sale sale = createSale();
      this.saleRepository.save(sale);
    }
  }

  // Helpers
  private double getRandomDiscount() {
    double[] discounts = {0, 0.05, 0.1, 0.15, 0.2, 0.3, 0.4, 0.5};
    Random random = new Random();
    int randomIndex = random.nextInt(discounts.length);
    return discounts[randomIndex];
  }

  private Sale createSale() {
    Sale sale = new Sale();
    Car car = this.carService.findRandomCar();
    if (this.saleRepository.findByCar(car) == null) {
      sale.setCar(carService.findRandomCar());
    }

    sale.setCustomer(this.customerService.findRandomCustomer());
    sale.setDiscount(getRandomDiscount());
    return sale;
  }
}
