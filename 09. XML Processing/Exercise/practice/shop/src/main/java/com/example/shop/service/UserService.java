package com.example.shop.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface UserService {

  void seedUsers() throws JAXBException, FileNotFoundException;
}
