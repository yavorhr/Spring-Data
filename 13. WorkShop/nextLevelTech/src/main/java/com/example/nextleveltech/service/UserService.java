package com.example.nextleveltech.service;

import com.example.nextleveltech.model.dto.UserLoginDto;
import com.example.nextleveltech.model.dto.UserRegisterDto;

public interface UserService {
  boolean registerUser(UserRegisterDto userRegisterDto);

  Long validateUserLoginDetails(UserLoginDto dto);
}
