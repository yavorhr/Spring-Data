package com.example.realdeal.service.impl;

import com.example.realdeal.service.SellerService;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class SellerServiceImpl implements SellerService {

  @Override
  public boolean areImported() {
    return false;
  }

  @Override
  public String readSellersFromFile() throws IOException, JAXBException {
    return null;
  }

  @Override
  public String importSellers() throws IOException, JAXBException {
    return null;
  }
}
