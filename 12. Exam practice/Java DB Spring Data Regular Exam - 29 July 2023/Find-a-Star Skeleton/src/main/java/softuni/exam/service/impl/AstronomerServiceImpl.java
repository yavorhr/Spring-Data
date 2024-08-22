package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.AstronomersRootSeedDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AstronomerServiceImpl implements AstronomerService {
  private static final String ASTRONOMERS_FILE_PATH = "src/main/resources/files/xml/astronomers.xml";

  private final AstronomerRepository astronomerRepository;
  private final XmlParser xmlParser;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final StarService starService;

  public AstronomerServiceImpl(AstronomerRepository astronomerRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, StarService starService) {
    this.astronomerRepository = astronomerRepository;
    this.xmlParser = xmlParser;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.starService = starService;
  }

  @Override
  public boolean areImported() {
    return this.astronomerRepository.count() > 0;
  }

  @Override
  public String readAstronomersFromFile() throws IOException {
    return Files.readString(Path.of(ASTRONOMERS_FILE_PATH));
  }

  @Override
  public String importAstronomers() throws IOException, JAXBException {
    StringBuilder sb = new StringBuilder();
    AstronomersRootSeedDto rootDto =
            this.xmlParser.fromFile(ASTRONOMERS_FILE_PATH, AstronomersRootSeedDto.class);

    List<Astronomer> collect = rootDto.getAstronomers()
            .stream()
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              Long starId = dto.getObservingStarId();
              if (this.starService.findStarById(starId) == null) {
                isValid = false;
              }

              if (this.astronomerRepository.findByFirstNameAndLastName(dto.getFirstName(), dto.getLastName()) != null) {
                isValid = false;
              }

              sb.append(isValid ? String.format("Successfully imported astronomer %s %s - %.2f",
                      dto.getFirstName(),
                      dto.getLastName(),
                      dto.getAverageObservationHours()) : "Invalid astronomer")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> this.modelMapper.map(dto, Astronomer.class))
            .collect(Collectors.toList());
    System.out.println();

    return sb.toString();
  }

}
