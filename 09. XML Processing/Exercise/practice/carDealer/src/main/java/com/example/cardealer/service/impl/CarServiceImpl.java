package com.example.cardealer.service.impl;

import com.example.cardealer.constant.ProjectConstants;
import com.example.cardealer.model.dto.seed.CarsRootDto;
import com.example.cardealer.model.entity.Car;
import com.example.cardealer.repository.CarRepository;
import com.example.cardealer.service.CarService;
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
  private final SupplierService supplierService;

  public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, SupplierService supplierService) {
    this.carRepository = carRepository;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.xmlParser = xmlParser;
    this.supplierService = supplierService;
  }

  @Override
  public void seedCars() throws JAXBException, FileNotFoundException {
    CarsRootDto rootDto = this.xmlParser.fromFile(ProjectConstants.SEED_CARS, CarsRootDto.class);

    rootDto.getCars()
            .stream()
            .filter(this.validationUtil::isValid)
            .map(dto -> {
              Car entity = this.modelMapper.map(dto, Car.class);


              entity.setParts();
            })
  }
}
