package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.AstronomerService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class AstronomerServiceImpl implements AstronomerService {

  @Override
  public boolean areImported() {
    return false;
  }

  @Override
  public String readAstronomersFromFile() throws IOException {
    return null;
  }

  @Override
  public String importAstronomers() throws IOException, JAXBException {
    return null;
  }
}
