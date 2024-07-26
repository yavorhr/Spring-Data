package com.example.productshop_practice.service;

import com.example.productshop_practice.model.entity.User;

import java.io.IOException;

public interface UserService {
  void seedUsers() throws IOException;

  User findRandomUser();
}
