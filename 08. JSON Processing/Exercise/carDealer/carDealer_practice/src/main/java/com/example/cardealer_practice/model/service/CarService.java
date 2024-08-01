package com.example.cardealer_practice.model.service;

import com.example.cardealer_practice.model.entity.Car;
import com.example.cardealer_practice.model.entity.dto.view.CarViewDto;

import java.io.IOException;
import java.util.List;

public interface CarService {
  void seedCars() throws IOException;

  Car findRandomCar();

  List<CarViewDto> findCarsByMake(String toyota);
}
