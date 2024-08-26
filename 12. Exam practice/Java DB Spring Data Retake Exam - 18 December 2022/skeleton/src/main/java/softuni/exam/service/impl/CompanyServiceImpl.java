package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.CompanyDto;
import softuni.exam.models.dto.xml.CompanyRootDto;
import softuni.exam.models.entity.Company;
import softuni.exam.repository.CompanyRepository;
import softuni.exam.service.CompanyService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CompanyServiceImpl implements CompanyService {
  private static final String COMPANIES_FILE_PATH = "src/main/resources/files/xml/companies.xml";
  private final CompanyRepository companyRepository;
  private final CountryService countryService;
  private final XmlParser xmlParser;
  private final ValidationUtil validationUtil;
  private final ModelMapper modelMapper;

  public CompanyServiceImpl(CompanyRepository companyRepository, CountryService countryService, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
    this.companyRepository = companyRepository;
    this.countryService = countryService;
    this.xmlParser = xmlParser;
    this.validationUtil = validationUtil;
    this.modelMapper = modelMapper;
  }

  @Override
  public boolean areImported() {
    return this.companyRepository.count() > 0;
  }

  @Override
  public String readCompaniesFromFile() throws IOException {
    return Files.readString(Path.of(COMPANIES_FILE_PATH));
  }

  @Override
  public String importCompanies() throws IOException, JAXBException {
    StringBuilder sb = new StringBuilder();

    CompanyRootDto rootDto =
            this.xmlParser.fromFile(COMPANIES_FILE_PATH, CompanyRootDto.class);

    System.out.println();

    System.out.println();

    rootDto.getCompanies()
            .stream()
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              isValid = companyNameExist(dto, isValid);

              sb.append(isValid
                      ? String.format("Successfully imported company %s - %d",
                      dto.getName(),
                      dto.getCountryId())
                      : "Invalid country")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {
              Company company = this.modelMapper.map(dto, Company.class);
              company.setCountry(this.countryService.findCountryById(dto.getCountryId()));

              return company;
            })
            .forEach(this.companyRepository::save);

    return sb.toString().trim();
  }

  // Helpers
  private boolean companyNameExist(CompanyDto dto, boolean isValid) {
    if (this.companyRepository.findByName(dto.getName()) != null) {
      isValid = false;
    }
    return isValid;
  }

}


