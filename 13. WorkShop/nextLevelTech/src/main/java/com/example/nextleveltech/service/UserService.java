package com.example.nextleveltech.service;

import com.example.nextleveltech.model.dto.UserRegisterDto;

public interface UserService {
  boolean registerUser(UserRegisterDto userRegisterDto);
}
