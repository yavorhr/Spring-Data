package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.ApartmentDto;
import softuni.exam.models.dto.xml.ApartmentsRootDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
public class ApartmentServiceImpl implements ApartmentService {
  private static final String APARTMENTS_FILE_PATH = "src/main/resources/files/xml/apartments.xml";
  private final ApartmentRepository apartmentRepository;
  private final XmlParser xmlParser;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final TownService townService;

  public ApartmentServiceImpl(ApartmentRepository apartmentRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, TownService townService) {
    this.apartmentRepository = apartmentRepository;
    this.xmlParser = xmlParser;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.townService = townService;
  }

  @Override
  public boolean areImported() {
    return this.apartmentRepository.count() > 0;
  }

  @Override
  public String readApartmentsFromFile() throws IOException {
    return Files.readString(Path.of(APARTMENTS_FILE_PATH));
  }

  @Override
  public String importApartments() throws IOException, JAXBException {
    StringBuilder sb = new StringBuilder();

    ApartmentsRootDto rootDto = this.xmlParser.fromFile(APARTMENTS_FILE_PATH, ApartmentsRootDto.class);

    rootDto.getApartments()
            .stream()
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (this.apartmentRepository.findByTown_TownNameAndArea(
                      dto.getTown(),
                      dto.getArea()) != null) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported apartment%s - %,2f",
                      dto.getApartmentType(),
                      dto.getArea())
                      : "Invalid apartment")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {
              Apartment apartment = this.modelMapper.map(dto, Apartment.class);
              Optional<Town> town = this.townService.findTownByName(dto.getTown());

              town.ifPresent(apartment::setTown);

              return apartment;
            })
            .forEach(this.apartmentRepository::save);

    return sb.toString().trim();
  }

  private boolean apartmentAlreadyExist(List<ApartmentDto> towns, ApartmentDto dto) {
    return towns
            .stream()
            .anyMatch(t -> t.getTown().equals(dto.getTown()) &&
                    t.getArea().equals(dto.getArea()) &&
                    t.getApartmentType().equals(dto.getApartmentType()));
  }
}
