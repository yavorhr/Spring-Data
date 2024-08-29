package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.PartSeedDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartRepository;
import softuni.exam.service.PartService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartServiceImpl implements PartService {
  private static final String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";
  private final PartRepository partRepository;
  private final Gson gson;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;

  public PartServiceImpl(PartRepository partRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
    this.partRepository = partRepository;
    this.gson = gson;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public boolean areImported() {
    return this.partRepository.count() > 0;
  }

  @Override
  public String readPartsFileContent() throws IOException {
    return Files.readString(Path.of(PARTS_FILE_PATH));
  }

  @Override
  public String importParts() throws IOException {
    StringBuilder sb = new StringBuilder();
    System.out.println(readPartsFileContent());

    Arrays.stream(this.gson.fromJson(readPartsFileContent(), PartSeedDto[].class))
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (isValid && this.partRepository.findByPartName(dto.getPartName()).isPresent()) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported part %s - %,2f",
                      dto.getPartName(),
                      dto.getPrice())
                      : "Invalid part")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> this.modelMapper.map(dto, Part.class))
            .forEach(this.partRepository::save);

    return sb.toString().trim();
  }
}
