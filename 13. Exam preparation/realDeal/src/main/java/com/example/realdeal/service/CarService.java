package com.example.realdeal.service;

import com.example.realdeal.model.entity.Car;

import java.io.IOException;

public interface CarService {

  boolean areImported();

  String readCarsFileContent() throws IOException;

  String importCars() throws IOException;

  String getCarsOrderByPicturesCountThenByMake();

  Car findById(Long id);

}
