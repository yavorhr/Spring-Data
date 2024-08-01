package com.example.cardealer_practice.comparator;

import com.example.cardealer_practice.model.entity.dto.view.CustomerBoughtCarsViewDto;

import java.util.Comparator;

public class ComparatorByTotalMoneyAndBoughtCars implements Comparator<CustomerBoughtCarsViewDto> {
  @Override
  public int compare(CustomerBoughtCarsViewDto dto1, CustomerBoughtCarsViewDto dto2) {
    int result = Double.compare(dto2.getSpentMoney().doubleValue(), dto1.getSpentMoney().doubleValue());
    if (result == 0) {
      result = Integer.compare(dto2.getBoughtCars(), dto1.getBoughtCars());
    }
    return result;
  }
}
