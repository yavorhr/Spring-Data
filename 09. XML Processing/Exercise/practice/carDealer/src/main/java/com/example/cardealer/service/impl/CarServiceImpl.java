package com.example.cardealer.service.impl;

import com.example.cardealer.constant.ProjectConstants;
import com.example.cardealer.model.dto.seed.CarsRootDto;
import com.example.cardealer.model.entity.Car;
import com.example.cardealer.repository.CarRepository;
import com.example.cardealer.service.CarService;
import com.example.cardealer.service.PartService;
import com.example.cardealer.service.SupplierService;
import com.example.cardealer.util.ValidationUtil;
import com.example.cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

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
}
