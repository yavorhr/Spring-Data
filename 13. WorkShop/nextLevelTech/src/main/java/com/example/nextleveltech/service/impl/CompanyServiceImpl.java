package com.example.nextleveltech.service.impl;

import com.example.nextleveltech.repositoriy.CompanyRepository;
import com.example.nextleveltech.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
  private final CompanyRepository companyRepository;

  public CompanyServiceImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Override
  public boolean areFilesImported() {
    return this.companyRepository.existsAllBy();
  }
}
