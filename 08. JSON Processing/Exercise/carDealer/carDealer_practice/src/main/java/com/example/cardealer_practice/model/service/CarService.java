package com.example.cardealer_practice.model.service;

import com.example.cardealer_practice.model.entity.Car;

import java.io.IOException;

public interface CarService {
  void seedCars() throws IOException;

  Car findRandomCar();
}
