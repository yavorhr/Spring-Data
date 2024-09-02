package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.TownsSeedDtos;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TownServiceImpl implements TownService {
  private static final String TOWN_FILE_PATH = "src/main/resources/files/json/towns.json";
  private final TownRepository townRepository;
  private final Gson gson;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;

  public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
    this.townRepository = townRepository;
    this.gson = gson;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public boolean areImported() {
    return this.townRepository.count() > 0;
  }

  @Override
  public String readTownsFileContent() throws IOException {
    return Files.readString(Path.of(TOWN_FILE_PATH));
  }

  @Override
  public String importTowns() throws IOException {
    StringBuilder sb = new StringBuilder();

    Arrays.stream(this.gson.fromJson(readTownsFileContent(), TownsSeedDtos[].class))
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (this.townRepository.findByTownName(dto.getTownName()).isPresent()) {
                isValid = false;
              }

              sb.append(isValid ? String.format("Successfully imported town %s - %d",
                      dto.getTownName(),
                      dto.getPopulation())
                      : "Invalid town")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> this.modelMapper.map(dto, Town.class))
            .forEach(this.townRepository::save);

    return sb.toString().trim();
  }

  @Override
  public Optional<Town> findTownByName(String name) {
    return this.townRepository.findByTownName(name);
  }

}



