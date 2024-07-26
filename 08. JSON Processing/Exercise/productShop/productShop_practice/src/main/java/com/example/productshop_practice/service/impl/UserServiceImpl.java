package com.example.productshop_practice.service.impl;

import com.example.productshop_practice.constant.GlobalConstants;
import com.example.productshop_practice.model.dto.UserSeedDto;
import com.example.productshop_practice.model.entity.User;
import com.example.productshop_practice.repository.UserRepository;
import com.example.productshop_practice.service.UserService;
import com.example.productshop_practice.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final Gson gson;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;

  public UserServiceImpl(UserRepository userRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
    this.userRepository = userRepository;
    this.gson = gson;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public void seedUsers() throws IOException {
    if (this.userRepository.count() == 0) {
      String usersJson = Files.readString(Path.of(GlobalConstants.SEED_USERS_PATH));

      UserSeedDto[] userSeedDtos = this.gson.fromJson(usersJson, UserSeedDto[].class);
      Arrays.stream(userSeedDtos)
              .filter(validationUtil::isValid)
              .map(u -> this.modelMapper.map(u, User.class))
              .forEach(this.userRepository::save);
    }
  }

  @Override
  public User findRandomUser() {
    long randomId = ThreadLocalRandom.current().nextLong(1, this.userRepository.count() + 1);
    return this.userRepository
            .findById(randomId)
            .orElse(null);
  }
}
