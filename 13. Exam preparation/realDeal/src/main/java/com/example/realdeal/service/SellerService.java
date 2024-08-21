package com.example.realdeal.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface SellerService {

  boolean areImported();

  String readSellersFromFile() throws IOException, JAXBException;

  String importSellers() throws IOException, JAXBException;
}
