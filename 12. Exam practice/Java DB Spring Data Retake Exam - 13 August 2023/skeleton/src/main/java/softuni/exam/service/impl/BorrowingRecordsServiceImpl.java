package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.BorrowingRecordsService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

  @Override
  public boolean areImported() {
    return false;
  }

  @Override
  public String readBorrowingRecordsFromFile() throws IOException {
    return null;
  }

  @Override
  public String importBorrowingRecords() throws IOException, JAXBException {
    return null;
  }

  @Override
  public String exportBorrowingRecords() {
    return null;
  }
}
