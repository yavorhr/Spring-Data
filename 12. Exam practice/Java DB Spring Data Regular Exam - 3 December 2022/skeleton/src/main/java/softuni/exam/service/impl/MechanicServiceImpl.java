package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.MechanicSeedDto;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicRepository;
import softuni.exam.service.MechanicService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class MechanicServiceImpl implements MechanicService {
  private static final String MECHANICS_FILE_PATH = "src/main/resources/files/json/mechanics.json";
  private final MechanicRepository mechanicRepository;
  private final Gson gson;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;

  public MechanicServiceImpl(MechanicRepository mechanicRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
    this.mechanicRepository = mechanicRepository;
    this.gson = gson;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public boolean areImported() {
    return this.mechanicRepository.count() > 0;
  }

  @Override
  public String readMechanicsFromFile() throws IOException {
    return Files.readString(Path.of(MECHANICS_FILE_PATH));
  }

  @Override
  public String importMechanics() throws IOException {
    StringBuilder sb = new StringBuilder();

    Arrays.stream(this.gson.fromJson(readMechanicsFromFile(), MechanicSeedDto[].class))
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (isValid && doUniqueValuesExist(dto.getFirstName(), dto.getEmail())) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported mechanic %s %s",
                      dto.getFirstName(),
                      dto.getLastName())
                      : "Invalid mechanic")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> this.modelMapper.map(dto, Mechanic.class))
            .forEach(this.mechanicRepository::save);

    return sb.toString().trim();
  }

  @Override
  public Mechanic findMechanicByFirstName(String firstName) {
    return this.mechanicRepository.findByFirstName(firstName).orElse(null);
  }

  // Helpers
  private boolean doUniqueValuesExist(String firstName, String email) {
    return this.mechanicRepository.findByFirstName(firstName).isPresent()
            || this.mechanicRepository.findByEmail(email).isPresent();
  }
}
