package com.example.cardealer.service.impl;

import com.example.cardealer.constant.ProjectConstants;
import com.example.cardealer.model.dto.seed.CarsRootDto;
import com.example.cardealer.model.dto.view.FourthQuery.CarMakeModelDistanceViewDto;
import com.example.cardealer.model.dto.view.FourthQuery.CarsWithPartsRootViewDto;
import com.example.cardealer.model.dto.view.SecondQuery.CarIdMakeModelDistance;
import com.example.cardealer.model.dto.view.SecondQuery.CarsRootViewDto;
import com.example.cardealer.model.entity.Car;
import com.example.cardealer.repository.CarRepository;
import com.example.cardealer.service.CarService;
import com.example.cardealer.service.PartService;
import com.example.cardealer.util.ValidationUtil;
import com.example.cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
  private final CarRepository carRepository;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final XmlParser xmlParser;
  private final PartService partService;

  public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, PartService partService) {
    this.carRepository = carRepository;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.xmlParser = xmlParser;
    this.partService = partService;
  }

  @Override
  public void seedCars() throws JAXBException, FileNotFoundException {
    if (carRepository.count() > 0) {
      return;
    }

    CarsRootDto rootDto = this.xmlParser.fromFile(ProjectConstants.SEED_CARS, CarsRootDto.class);

    rootDto.getCars()
            .stream()
            .filter(this.validationUtil::isValid)
            .map(dto -> {
              Car entity = this.modelMapper.map(dto, Car.class);

              entity.setParts(partService.findRandomParts());
              return entity;
            })
            .forEach(this.carRepository::save);
  }

  @Override
  public Car findRandomCar() {
    long randomId = ThreadLocalRandom.current().nextLong(1, this.carRepository.count() + 1);
    return this.carRepository.findById(randomId).orElse(null);
  }

  @Override
  public CarsRootViewDto findAllToyotaCarsOrderedByModelAscAndDistanceDesc(String make) {
    var carsRootViewDto = new CarsRootViewDto();

    List<CarIdMakeModelDistance> innerDtos = this.carRepository
            .findAllByMakeOrderByModelAscTravelledDistanceDesc(make)
            .stream()
            .filter(this.validationUtil::isValid)
            .map(e -> this.modelMapper.map(e, CarIdMakeModelDistance.class))
            .collect(Collectors.toList());

    carsRootViewDto.setCars(innerDtos);

    return carsRootViewDto;
  }

  @Override
  public CarsWithPartsRootViewDto findAllCarsWithTheirParts() {
    var rootDto = new CarsWithPartsRootViewDto();

    List<CarMakeModelDistanceViewDto> innerDtos = this.carRepository.findAll()
            .stream()
            .map(e -> this.modelMapper.map(e, CarMakeModelDistanceViewDto.class))
            .collect(Collectors.toList());

    rootDto.setCars(innerDtos);

    return rootDto;
  }
}
