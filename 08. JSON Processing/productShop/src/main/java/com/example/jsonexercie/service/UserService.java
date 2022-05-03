package com.example.jsonexercie.service;

import com.example.jsonexercie.model.Dto.UserSoldDto;
import com.example.jsonexercie.model.Entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void seedUsers() throws IOException;

    User findRandomUser();

    List<UserSoldDto> findAllUsersWithMoreThanOneSoldProducts();
}
