package com.example.shop.service;

import com.example.shop.model.entity.User;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface UserService {

  void seedUsers() throws JAXBException, FileNotFoundException;

  User getRandomUser();
}
