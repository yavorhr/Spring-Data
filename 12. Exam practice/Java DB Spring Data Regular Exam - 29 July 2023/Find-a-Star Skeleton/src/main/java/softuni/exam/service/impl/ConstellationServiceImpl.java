package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.ConstellationsSeedDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class ConstellationServiceImpl implements ConstellationService {
  private static final String CONSTELLATIONS_PATH_FILE = "src/main/resources/files/json/constellations.json";
  private final ConstellationRepository constellationRepository;
  private final Gson gson;
  private final ValidationUtil validationUtil;
  private final ModelMapper modelMapper;

  public ConstellationServiceImpl(ConstellationRepository constellationRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
    this.constellationRepository = constellationRepository;
    this.gson = gson;
    this.validationUtil = validationUtil;
    this.modelMapper = modelMapper;
  }

  @Override
  public boolean areImported() {
    return this.constellationRepository.count() > 0;
  }

  @Override
  public String readConstellationsFromFile() throws IOException {
    return Files.readString(Path.of(CONSTELLATIONS_PATH_FILE));
  }

  @Override
  public String importConstellations() throws IOException {
    StringBuilder sb = new StringBuilder();

    Arrays.stream(this.gson.fromJson(readConstellationsFromFile(), ConstellationsSeedDto[].class))
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              isValid = isConstellationAlreadyAdded(dto, isValid);

              sb.append(isValid
                      ? (String.format("Successfully imported constellation %s - %s."
                      , dto.getName()
                      , dto.getDescription()))
                      : "Invalid constellation")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> this.modelMapper.map(dto, Constellation.class))
            .forEach(this.constellationRepository::save);

    return sb.toString().trim();
  }

  @Override
  public Constellation findById(Long id) {
    return this.constellationRepository.findById(id).orElse(null);
  }

  // Helpers
  private boolean isConstellationAlreadyAdded(ConstellationsSeedDto dto, boolean isValid) {
    if (this.constellationRepository.findByName(dto.getName()) != null) {
      isValid = false;
    }
    return isValid;
  }

}
