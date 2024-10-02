package exam.service.impl;

import exam.model.entity.Town;
import exam.model.service.xml.TownsRootModel;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {
  private static final String TOWNS_FILE_PATH = "src/main/resources/files/xml/towns.xml";
  private final TownRepository townRepository;
  private final ModelMapper modelMapper;
  private final XmlParser xmlParser;
  private final ValidationUtil validationUtil;

  public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
    this.townRepository = townRepository;
    this.modelMapper = modelMapper;
    this.xmlParser = xmlParser;
    this.validationUtil = validationUtil;
  }

  @Override
  public boolean areImported() {
    return this.townRepository.count() > 0;
  }

  @Override
  public String readTownsFileContent() throws IOException {
    return Files.readString(Path.of(TOWNS_FILE_PATH));
  }

  @Override
  public String importTowns() throws JAXBException, FileNotFoundException {
    StringBuilder sb = new StringBuilder();

    this.xmlParser.fromFile(TOWNS_FILE_PATH, TownsRootModel.class).getTowns()
            .stream()
            .filter(t -> {

              boolean isValid = this.validationUtil.isValid(t);

              if (townNameExist(t.getName())) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported Town %s", t.getName())
                      : "Invalid town")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> this.modelMapper.map(dto, Town.class))
            .forEach(this.townRepository::save);

    return sb.toString().trim();
  }

  private boolean townNameExist(String name) {
    return this.townRepository.findByName(name).isPresent();
  }
}
