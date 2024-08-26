package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.PersonService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class PersonServiceImpl implements PersonService {
  @Override
  public boolean areImported() {
    return false;
  }

  @Override
  public String readPeopleFromFile() throws IOException {
    return null;
  }

  @Override
  public String importPeople() throws IOException, JAXBException {
    return null;
  }
}
