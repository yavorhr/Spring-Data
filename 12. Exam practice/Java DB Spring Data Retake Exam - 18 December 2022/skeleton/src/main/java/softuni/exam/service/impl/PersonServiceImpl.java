package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.PeopleSeedDto;
import softuni.exam.models.entity.Person;
import softuni.exam.repository.PersonRepository;
import softuni.exam.service.CountryService;
import softuni.exam.service.PersonService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PersonServiceImpl implements PersonService {
  private static final String PEOPLE_FILE_PATH = "src/main/resources/files/json/people.json";
  private final PersonRepository personRepository;
  private final Gson gson;
  private final ValidationUtil validationUtil;
  private final ModelMapper modelMapper;
  private final CountryService countryService;

  public PersonServiceImpl(PersonRepository personRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, CountryService countryService) {
    this.personRepository = personRepository;
    this.gson = gson;
    this.validationUtil = validationUtil;
    this.modelMapper = modelMapper;
    this.countryService = countryService;
  }

  @Override
  public boolean areImported() {
    return this.personRepository.count() > 0;
  }

  @Override
  public String readPeopleFromFile() throws IOException {
    return Files.readString(Path.of(PEOPLE_FILE_PATH));
  }

  @Override
  public String importPeople() throws IOException {
    StringBuilder sb = new StringBuilder();

    Arrays.stream(this.gson.fromJson(readPeopleFromFile(), PeopleSeedDto[].class))
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              isValid = firstNameAlreadyExist(dto.getFirstName(), isValid);
              isValid = emailAlreadyExist(dto.getEmail(), isValid);
              isValid = numberAlreadyExist(dto.getPhone(), isValid);

              sb.append(isValid
                      ? String.format("Successfully imported person %s %s",
                      dto.getFirstName(),
                      dto.getLastName())
                      : "Invalid person")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {
              Person person = this.modelMapper.map(dto, Person.class);
              person.setCountry(this.countryService.findCountryById(dto.getCountry()));

              return person;
            })
            .forEach(this.personRepository::save);

    return sb.toString().trim();
  }

  // Helpers
  private boolean firstNameAlreadyExist(String firstName, boolean isValid) {
    if (this.personRepository.findByFirstName(firstName) != null) {
      isValid = false;
    }
    return isValid;
  }

  private boolean emailAlreadyExist(String email, boolean isValid) {
    if (this.personRepository.findByEmail(email) != null) {
      isValid = false;
    }
    return isValid;
  }

  private boolean numberAlreadyExist(String phone, boolean isValid) {
    if (this.personRepository.findByPhone(phone) != null) {
      isValid = false;
    }
    return isValid;
  }
}
