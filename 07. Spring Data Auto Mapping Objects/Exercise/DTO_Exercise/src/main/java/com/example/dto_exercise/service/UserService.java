package com.example.dto_exercise.service;

import com.example.dto_exercise.model.dto.UserLoginDto;
import com.example.dto_exercise.model.dto.UserRegisterDto;
import com.example.dto_exercise.userContext.UserContext;

public interface UserService {

  void registerUser(UserRegisterDto userRegisterDto);

  void loginUser(UserLoginDto userLoginDto, UserContext userContext);

  void logout(UserContext context);

  void printGamesByUserId();
}
