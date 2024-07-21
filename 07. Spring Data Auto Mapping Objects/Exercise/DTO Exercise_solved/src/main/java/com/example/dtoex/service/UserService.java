package com.example.dtoex.service;

import com.example.dtoex.model.dto.UserLoginDto;
import com.example.dtoex.model.dto.UserRegisterDto;
import com.example.dtoex.model.entity.User;

public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logoutUser();

}
