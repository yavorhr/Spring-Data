package com.example.shop.service;

import com.example.shop.model.dto.view.FourthQuery.UsersAndCountRootViewDto;
import com.example.shop.model.dto.view.SecondQuery.UsersRootViewDto;
import com.example.shop.model.entity.User;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface UserService {

  void seedUsers() throws JAXBException, FileNotFoundException;

  User getRandomUser();

  UsersRootViewDto findUsersWithMoreThanOneSoldProducts();

  UsersAndCountRootViewDto findAllUsersWithSoldProducts();
}
