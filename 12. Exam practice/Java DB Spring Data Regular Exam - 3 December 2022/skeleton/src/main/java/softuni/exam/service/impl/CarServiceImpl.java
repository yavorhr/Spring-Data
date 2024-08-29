package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.MechanicSeedDto;
import softuni.exam.models.dto.xml.CarsRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
  private static final String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";
  private final CarRepository carRepository;
  private final XmlParser xmlParser;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;

  public CarServiceImpl(CarRepository carRepository, XmlParser xmlParser,
                        ModelMapper modelMapper, ValidationUtil validationUtil) {
    this.carRepository = carRepository;
    this.xmlParser = xmlParser;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public boolean areImported() {
    return this.carRepository.count() > 0;
  }

  @Override
  public String readCarsFromFile() throws IOException {
    return Files.readString(Path.of(CARS_FILE_PATH));
  }

  @Override
  public String importCars() throws IOException, JAXBException {
    StringBuilder sb = new StringBuilder();

    CarsRootDto carsRootDto = this.xmlParser.fromFile(CARS_FILE_PATH, CarsRootDto.class);

    carsRootDto.getCars()
            .stream()
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (isValid && this.carRepository.findByPlateNumber(dto.getPlateNumber()).isPresent()) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported car %s - %s",
                      dto.getMake(),
                      dto.getModel())
                      : "Invalid car")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> this.modelMapper.map(dto, Car.class))
            .forEach(this.carRepository::save);

    System.out.println();
    return sb.toString().trim();
  }
}
