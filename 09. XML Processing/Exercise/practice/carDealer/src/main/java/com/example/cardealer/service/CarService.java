package com.example.cardealer.service;

import com.example.cardealer.model.dto.view.FourthQuery.CarsWithPartsRootViewDto;
import com.example.cardealer.model.dto.view.SecondQuery.CarsRootViewDto;
import com.example.cardealer.model.entity.Car;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CarService {

  void seedCars() throws JAXBException, FileNotFoundException;

  Car findRandomCar();

  CarsRootViewDto findAllToyotaCarsOrderedByModelAscAndDistanceDesc(String toyota);

  CarsWithPartsRootViewDto findAllCarsWithTheirParts();
}