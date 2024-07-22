package com.example.dto_exercise.service;

import com.example.dto_exercise.model.dto.UserRegisterDto;
import com.example.dto_exercise.model.entity.User;
import com.example.dto_exercise.repository.UserRepository;
import com.example.dto_exercise.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
  private final ValidationUtil validationUtil;
  private final ModelMapper modelMapper;
  private final UserRepository userRepository;

  public UserServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper, UserRepository userRepository) {
    this.validationUtil = validationUtil;
    this.modelMapper = modelMapper;
    this.userRepository = userRepository;
  }

  @Override
  public void registerUser(UserRegisterDto userRegisterDto) {
    if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmedPassword())) {
      System.out.println("Password and Confirm password doesn't match!");
      return;
    }
    Set<ConstraintViolation<UserRegisterDto>> violation = validationUtil.violation(userRegisterDto);

    if (!violation.isEmpty()) {
      violation
              .stream()
              .map(ConstraintViolation::getMessage)
              .forEach(System.out::println);
      return;
    }

    User user = this.modelMapper.map(userRegisterDto, User.class);
    this.userRepository.save(user);
    System.out.printf("%s was registered%n", user.getFullName());
  }
}
