package com.example.carDealer.services.impl;

import com.example.carDealer.domain.dtos.seedDataDtos.CarImportDto;
import com.example.carDealer.domain.dtos.seedDataDtos.CarImportRootElement;
import com.example.carDealer.domain.dtos.views.*;
import com.example.carDealer.domain.entities.Car;
import com.example.carDealer.domain.entities.Part;
import com.example.carDealer.domain.repositories.CarRepository;
import com.example.carDealer.domain.repositories.PartRepository;
import com.example.carDealer.services.CarService;
import com.example.carDealer.utils.XmlParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final static String CAR_PATH = "src/main/resources/xmls/cars.xml";
    private final static String EXPORT_CAR_PATH = "src/main/resources/xmls/exported/carsFromToyota.xml";
    private final static String EXPORT_CAR_PARTS_PATH = "src/main/resources/xmls/exported/carsWithParts.xml";
    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository,
                          ModelMapper modelMapper, Gson gson, XmlParser xmlParser) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    @Transactional
    public void seedCar() throws IOException, JAXBException {
        CarImportRootElement carImportRootElement = this.xmlParser.parseXml(CarImportRootElement.class, CAR_PATH);

        for (CarImportDto carDto : carImportRootElement.getCars()) {
            Car map = this.modelMapper.map(carDto, Car.class);
            map.setParts(getTenRandomParts());
            this.carRepository.saveAndFlush(map);
        }
    }

    @Override
    public void getCarByMake() throws JAXBException {
        List<CarFromToyotaDto> dtos = this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota")
                .stream()
                .map(c -> this.modelMapper.map(c, CarFromToyotaDto.class))
                .collect(Collectors.toList());
        CarFromToyotaRootDto carFromToyotaRootDto = new CarFromToyotaRootDto();
        carFromToyotaRootDto.setCars(dtos);

        this.xmlParser.exportXml(carFromToyotaRootDto, CarFromToyotaRootDto.class, EXPORT_CAR_PATH);
    }

    @Override
    public void getCarsWithParts() throws JAXBException {
        List<CarsDto> carsDtos = new ArrayList<>();
        this.carRepository.findAll().forEach(c -> {
            List<PartDto> partDtos = new ArrayList<>();
            CarsDto car = this.modelMapper.map(c, CarsDto.class);
            c.getParts().forEach(p -> {
                partDtos.add(this.modelMapper.map(p, PartDto.class));
            });
            RootPartDto rootPartDto = new RootPartDto();
            rootPartDto.setParts(partDtos);

            car.setPartDto(rootPartDto);
            carsDtos.add(car);
        });

        CarsPartsDto carsPartsDto = new CarsPartsDto();
        carsPartsDto.setCars(carsDtos);

        this.xmlParser.exportXml(carsPartsDto,CarsPartsDto.class,EXPORT_CAR_PARTS_PATH);

    }

    private Set<Part> getTenRandomParts() {
        Random random = new Random();
        Set<Part> parts = new LinkedHashSet<>();
        for (int i = 0; i < 5; i++) {
            long index = (long) random.nextInt((int) this.partRepository.count()) + 1;
            parts.add(this.partRepository.findById(index).get());
        }

        return parts;
    }
}
