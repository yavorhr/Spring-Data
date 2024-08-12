package com.example.shop.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface ProductService {

  void seedProducts() throws JAXBException, FileNotFoundException;
}
