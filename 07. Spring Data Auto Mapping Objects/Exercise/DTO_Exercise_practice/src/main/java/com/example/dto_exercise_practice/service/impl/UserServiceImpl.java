package com.example.dto_exercise_practice.service.impl;

import com.example.dto_exercise_practice.model.dto.RegisterUserDto;
import com.example.dto_exercise_practice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final ModelMapper mapper;

  public UserServiceImpl(ModelMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public void registerUser(RegisterUserDto registerUserDto) {

  }
}
