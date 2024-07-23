package com.example.dto_exercise.service;

import com.example.dto_exercise.model.dto.UserLoginDto;
import com.example.dto_exercise.model.dto.UserRegisterDto;

public interface UserService {

  void registerUser(UserRegisterDto userRegisterDto);

  void loginUser(UserLoginDto userLoginDto);

  void logout();
}
