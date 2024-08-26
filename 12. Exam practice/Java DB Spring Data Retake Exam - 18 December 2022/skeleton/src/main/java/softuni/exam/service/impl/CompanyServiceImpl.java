package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.CompanyService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class CompanyServiceImpl implements CompanyService {
  @Override
  public boolean areImported() {
    return false;
  }

  @Override
  public String readCompaniesFromFile() throws IOException {
    return null;
  }

  @Override
  public String importCompanies() throws IOException, JAXBException {
    return null;
  }
}
