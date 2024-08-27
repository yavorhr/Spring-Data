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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    List<String> names = new ArrayList<>();

    Set<Company> collect = rootDto.getCompanies()
            .stream()
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (isValid && names.contains(dto.getName())) {
                isValid = false;
              } else {
                names.add(dto.getName());
              }

              sb.append(isValid
                      ? String.format("Successfully imported company %s - %d",
                      dto.getName(),
                      dto.getCountry())
                      : "Invalid company")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {
              Company company = this.modelMapper.map(dto, Company.class);

              if (this.countryService.findCountryById(dto.getCountry()) != null) {
                company.setCountry(this.countryService.findCountryById(dto.getCountry()));
              }
              return company;
            }).collect(Collectors.toSet());

    collect.forEach(this.companyRepository::save);

    return sb.toString().trim();
  }

  @Override
  public Company findCompanyById(Long companyId) {
    return this.companyRepository.findById(companyId).orElse(null);
  }


}


