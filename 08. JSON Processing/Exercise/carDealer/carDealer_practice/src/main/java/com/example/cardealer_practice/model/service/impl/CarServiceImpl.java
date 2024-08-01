package com.example.cardealer_practice.model.service.impl;

import com.example.cardealer_practice.constant.ProjectConstants;
import com.example.cardealer_practice.model.entity.Car;
import com.example.cardealer_practice.model.entity.Part;
import com.example.cardealer_practice.model.entity.dto.seed.CarDto;
import com.example.cardealer_practice.model.entity.dto.view.fifthQuery.CarViewDto;
import com.example.cardealer_practice.model.entity.dto.view.CarWithPartsDto;
import com.example.cardealer_practice.model.repository.CarRepository;
import com.example.cardealer_practice.model.service.CarService;
import com.example.cardealer_practice.model.service.PartService;
import com.example.cardealer_practice.model.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
  private final CarRepository carRepository;
  private final ModelMapper modelMapper;
  private final Gson gson;
  private final ValidationUtil validationUtil;
  private final PartService partService;

  public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, PartService partService) {
    this.carRepository = carRepository;
    this.modelMapper = modelMapper;
    this.gson = gson;
    this.validationUtil = validationUtil;
    this.partService = partService;
  }

  @Override
  public void seedCars() throws IOException {
    if (this.carRepository.count() > 0) {
      return;
    }

    String carsJson = Files.readString(Path.of(ProjectConstants.CARS_INPUT_PATH));
    CarDto[] carDtos = this.gson.fromJson(carsJson, CarDto[].class);

    Arrays.stream(carDtos)
            .filter(validationUtil::isValid)
            .map(dto -> {
              Car car = this.modelMapper.map(dto, Car.class);
              Set<Part> randomParts = this.partService.findRandomParts();

              car.setParts(randomParts);
              return car;
            })
            .forEach(this.carRepository::save);
  }

  @Override
  public Car findRandomCar() {
    long randomId = ThreadLocalRandom.current().nextLong(1, this.carRepository.count() + 1);
    return this.carRepository.findById(randomId).orElse(null);
  }

  @Override
  public List<CarViewDto> findCarsByMake(String make) {
    List<Car> cars = this.carRepository.findAllByMake(make);

    return cars
            .stream()
            .map(c -> this.modelMapper.map(c, CarViewDto.class))
            .collect(Collectors.toList());
  }

  @Override
  public List<CarWithPartsDto> findCarsWithParts() {
    List<Car> cars = this.carRepository.findAll();

    return cars
            .stream()
            .map(c -> this.modelMapper.map(c, CarWithPartsDto.class))
            .collect(Collectors.toList());

  }
}




