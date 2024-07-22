package com.example.dto_exercise_practice.service.impl;

import com.example.dto_exercise_practice.model.dto.RegisterUserDto;
import com.example.dto_exercise_practice.model.entity.User;
import com.example.dto_exercise_practice.service.UserService;
import com.example.dto_exercise_practice.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
  private final ModelMapper mapper;
  private final ValidationUtil validationUtil;

  public UserServiceImpl(ModelMapper mapper, ValidationUtil validationUtil) {
    this.mapper = mapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public void registerUser(RegisterUserDto registerUserDto) {
    if (!registerUserDto.getPassword().equals(registerUserDto.getConfirmPassword())) {
      System.out.println("Password does not match!");
      return;
    }

    Set<ConstraintViolation<RegisterUserDto>> violation = this.validationUtil.violation(registerUserDto);
    if (!violation.isEmpty()) {
      violation
              .stream()
              .map(ConstraintViolation::getMessage)
              .forEach(System.out::println);
      return;
    }

    User user = this.mapper.map(registerUserDto, User.class);

  }
}
