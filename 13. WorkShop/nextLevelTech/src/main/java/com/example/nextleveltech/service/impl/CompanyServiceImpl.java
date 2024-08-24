package com.example.nextleveltech.service.impl;

import com.example.nextleveltech.repositoriy.CompanyRepository;
import com.example.nextleveltech.service.CompanyService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class CompanyServiceImpl implements CompanyService {
  private static final String COMPANIES_FILE_PATH = "files/xmls/companies.xml";

  private final CompanyRepository companyRepository;

  public CompanyServiceImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Override
  public boolean areFilesImported() {
    return this.companyRepository.existsAllBy();
  }

  @Override
  public String getXmlDataForImport() throws IOException {
    return new String(this.getClass().getClassLoader().getResourceAsStream(COMPANIES_FILE_PATH).readAllBytes(), StandardCharsets.UTF_8);
  }
}
