package com.example.cardealer_practice.model.service.impl;

import com.example.cardealer_practice.comparator.ComparatorByTotalMoneyAndBoughtCars;
import com.example.cardealer_practice.constant.ProjectConstants;
import com.example.cardealer_practice.model.entity.Customer;
import com.example.cardealer_practice.model.entity.Sale;
import com.example.cardealer_practice.model.entity.dto.seed.CustomerDto;
import com.example.cardealer_practice.model.entity.dto.view.CustomerBoughtCarsViewDto;
import com.example.cardealer_practice.model.entity.dto.view.CustomerViewDto;
import com.example.cardealer_practice.model.repository.CustomerRepository;
import com.example.cardealer_practice.model.service.CustomerService;
import com.example.cardealer_practice.model.util.ValidationUtil;
import com.google.gson.Gson;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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
    if (this.customerRepository.count() > 0) {
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

  @Override
  public List<CustomerViewDto> findCustomersOrderByBirthDateAscYoungDriverAsc() {
    List<Customer> customers = this.customerRepository.findAllByOrderByBirthDateAscYoungDriverAsc();

    return customers
            .stream()
            .map(c -> {
              CustomerViewDto dto = this.modelMapper.map(c, CustomerViewDto.class);

              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
              dto.setBirthDate(c.getBirthDate().format(formatter));
              return dto;
            })
            .collect(Collectors.toList());
  }

  @Override
  public List<CustomerBoughtCarsViewDto> findCustomersByTopSales() {
    List<CustomerBoughtCarsViewDto> dtos = this.customerRepository.findAllByBoughtCars()
            .stream()
            .map(this::mapToCustomerBoughtCarsViewDto)
            .collect(Collectors.toList());

    dtos = sortDtos(dtos);

    return dtos;
  }

  // Helpers methods

  // map from Customer to CustomerDto
  private CustomerBoughtCarsViewDto mapToCustomerBoughtCarsViewDto(Customer c) {
    BigDecimal totalPrice = BigDecimal.ZERO;

    CustomerBoughtCarsViewDto dto =
            this.modelMapper.map(c, CustomerBoughtCarsViewDto.class);

    for (Sale sale : c.getSales()) {
      totalPrice = calcTotalMoney(totalPrice, sale);
    }

    dto.setSpentMoney(totalPrice);
    dto.setBoughtCars(c.getSales().size());
    return dto;
  }

  // sort dto using comparator
  private List<CustomerBoughtCarsViewDto> sortDtos(List<CustomerBoughtCarsViewDto> dtos) {
    dtos = dtos
            .stream()
            .sorted(new ComparatorByTotalMoneyAndBoughtCars())
            .collect(Collectors.toList());
    return dtos;
  }

  // calc total car money spend
  private BigDecimal calcTotalMoney(BigDecimal totalPrice, Sale sale) {
    totalPrice = totalPrice.add(BigDecimal.valueOf(
            sale
                    .getCar()
                    .getParts()
                    .stream()
                    .mapToDouble(part ->
                            Double.parseDouble(String.valueOf(part.getPrice())))
                    .sum()));
    return totalPrice;
  }
}

