package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.CountriesSeedDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
  private static final String COUNTRIES_FILE_PATH = "src/main/resources/files/json/countries.json";
  private final CountryRepository countryRepository;
  private final Gson gson;
  private final ValidationUtil validationUtil;
  private final ModelMapper modelMapper;

  public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
    this.countryRepository = countryRepository;
    this.gson = gson;
    this.validationUtil = validationUtil;
    this.modelMapper = modelMapper;
  }

  @Override
  public boolean areImported() {
    return this.countryRepository.count() > 0;
  }

  @Override
  public String readCountriesFileContent() throws IOException {
    return Files.readString(Path.of(COUNTRIES_FILE_PATH));
  }

  @Override
  public String importCountries() throws IOException {
    StringBuilder sb = new StringBuilder();

    Arrays.stream(this.gson.fromJson(readCountriesFileContent(), CountriesSeedDto[].class))
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              isValid = doesCountryNameExist(dto, isValid);
              isValid = doesCountryCodeExist(dto, isValid);

              sb.append(isValid
                      ? String.format("Successfully imported country %s - %s",
                      dto.getName(),
                      dto.getCode())
                      : "Invalid country")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> this.modelMapper.map(dto, Country.class))
            .forEach(this.countryRepository::save);

    return sb.toString().trim();
  }

  private boolean doesCountryNameExist(CountriesSeedDto dto, boolean isValid) {
    if (this.countryRepository.findByName(dto.getName()) != null) {
      isValid = false;
    }
    return isValid;
  }

  private boolean doesCountryCodeExist(CountriesSeedDto dto, boolean isValid) {
    if (this.countryRepository.findByCode(dto.getCode()) != null) {
      isValid = false;
    }
    return isValid;
  }
}
