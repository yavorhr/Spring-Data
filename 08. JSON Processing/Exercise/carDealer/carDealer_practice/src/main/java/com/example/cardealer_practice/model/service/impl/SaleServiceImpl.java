package com.example.cardealer_practice.model.service.impl;

import com.example.cardealer_practice.model.entity.Car;
import com.example.cardealer_practice.model.entity.Customer;
import com.example.cardealer_practice.model.entity.Sale;
import com.example.cardealer_practice.model.entity.dto.view.fifthQuery.CustomerWithPricesViewDto;
import com.example.cardealer_practice.model.repository.SaleRepository;
import com.example.cardealer_practice.model.service.CarService;
import com.example.cardealer_practice.model.service.CustomerService;
import com.example.cardealer_practice.model.service.SaleService;
import com.example.cardealer_practice.model.util.ValidationUtil;
import com.google.gson.Gson;;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {
  private final SaleRepository saleRepository;
  private final ModelMapper modelMapper;
  private final Gson gson;
  private final ValidationUtil validationUtil;
  private final CustomerService customerService;
  private final CarService carService;

  public SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, CustomerService customerService, CarService carService) {
    this.saleRepository = saleRepository;
    this.modelMapper = modelMapper;
    this.gson = gson;
    this.validationUtil = validationUtil;
    this.customerService = customerService;
    this.carService = carService;
  }

  @Override
  public void seedSales() {
    if (saleRepository.count() > 0) {
      return;
    }

    for (int i = 0; i < 15; i++) {
      Sale sale = new Sale();
      Customer randomCustomer = this.customerService.findRandomCustomer();
      Car randomCar = this.carService.findRandomCar();

      Sale saleWithCarAlreadyAdded =
              saleRepository.findByCar(randomCar).orElse(null);

      if (saleWithCarAlreadyAdded == null) {
        sale.setCar(randomCar);
        sale.setDiscount(randomCustomer.isYoungDriver() ? 0.05 : 0);
        sale.setCustomer(randomCustomer);
        this.saleRepository.save(sale);
      }
    }

  }

  @Override
  public List<CustomerWithPricesViewDto> findSalesWithAppliedDiscounts() {
    return this.saleRepository.findAll()
            .stream()
            .map(s -> {
              CustomerWithPricesViewDto dto = this.modelMapper.map(s, CustomerWithPricesViewDto.class);
              dto.setName(s.getCustomer().getName());
              dto.setDiscount(s.getDiscount());

              double price = s.getCar().getParts()
                      .stream()
                      .mapToDouble(p -> Double.parseDouble(String.valueOf(p.getPrice()))).sum();


              dto.setPrice(price);
              dto.setPriceWithDiscount(price - (price * s.getDiscount()));

              return dto;
            })
            .collect(Collectors.toList());
  }
}
