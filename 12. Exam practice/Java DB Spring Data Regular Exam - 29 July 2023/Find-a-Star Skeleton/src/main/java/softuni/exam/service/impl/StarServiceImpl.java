package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.exam.models.dto.json.StarsSeedDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class StarServiceImpl implements StarService {
  private static final String STARS_PATH_FILE = "src/main/resources/files/json/stars.json";
  private final StarRepository starRepository;

  private final Gson gson;
  private final ValidationUtil validationUtil;
  private final ModelMapper modelMapper;
  private final ConstellationService constellationService;


  public StarServiceImpl(StarRepository starRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, ConstellationService constellationService) {
    this.starRepository = starRepository;
    this.gson = gson;
    this.validationUtil = validationUtil;
    this.modelMapper = modelMapper;
    this.constellationService = constellationService;
  }

  @Override
  public boolean areImported() {
    return this.starRepository.count() > 0;
  }

  @Override
  public String readStarsFileContent() throws IOException {
    return Files.readString(Path.of(STARS_PATH_FILE));
  }

  @Override
  @Transactional
  public String importStars() throws IOException {
    StringBuilder sb = new StringBuilder();
    Arrays.stream(this.gson.fromJson(readStarsFileContent(), StarsSeedDto[].class))
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              isValid = ifStarAlreadyAdded(dto, isValid);

              isValid = ifConstellationDoesNotExist(dto, isValid);

              sb.append(isValid
                      ? String.format("Successfully imported star %s - %.2f light years",
                      dto.getName(),
                      dto.getLightYears())
                      : "Invalid star")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {
              Star starEntity = this.modelMapper.map(dto, Star.class);

              starEntity.setConstellation(this.constellationService.findById(dto.getConstellation()));
              return starEntity;
            })
            .forEach(this.starRepository::save);

    return sb.toString();
  }


  @Override
  public String exportStars() {
    return null;
  }

  @Override
  public Star findStarById(Long id) {
    return this.starRepository.findById(id).orElse(null);
  }

  // Helpers

  private boolean ifConstellationDoesNotExist(StarsSeedDto dto, boolean isValid) {
    if (this.constellationService.findById(dto.getConstellation()) == null) {
      isValid = false;
    }
    return isValid;
  }

  private boolean ifStarAlreadyAdded(StarsSeedDto dto, boolean isValid) {
    if (this.starRepository.findByName(dto.getName()).isPresent()) {
      isValid = false;
    }
    return isValid;
  }


}
