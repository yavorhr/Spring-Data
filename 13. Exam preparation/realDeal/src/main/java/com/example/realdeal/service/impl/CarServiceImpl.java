package com.example.realdeal.service.impl;

import com.example.realdeal.model.entity.Car;
import com.example.realdeal.service.CarService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CarServiceImpl implements CarService {

  @Override
  public boolean areImported() {
    return false;
  }

  @Override
  public String readCarsFileContent() throws IOException {
    return null;
  }

  @Override
  public String importCars() throws IOException {
    return null;
  }

  @Override
  public String getCarsOrderByPicturesCountThenByMake() {
    return null;
  }

  @Override
  public Car findById(Long id) {
    return null;
  }
}
