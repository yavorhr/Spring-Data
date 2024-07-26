package com.example.jsonexercie.service.Impl;

import com.example.jsonexercie.constant.GlobalConstants;
import com.example.jsonexercie.model.Dto.UserSeedDto;
import com.example.jsonexercie.model.Dto.UserSoldDto;
import com.example.jsonexercie.model.Entity.User;
import com.example.jsonexercie.repository.UserRepository;
import com.example.jsonexercie.service.UserService;
import com.example.jsonexercie.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_FILE_NAME = "users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers() throws IOException {
        if (userRepository.count() > 0) {
            return;
        }

        String usersContent = Files.readString(Path.of(GlobalConstants.RESOURCES_FILE_PATH + USER_FILE_NAME));
        UserSeedDto [] userSeedDtos = gson.fromJson(usersContent,UserSeedDto[].class);

        Arrays.stream(userSeedDtos)
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(this.userRepository::save);
    }

    @Override
    public User findRandomUser() {
       long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count()+1);
        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<UserSoldDto> findAllUsersWithMoreThanOneSoldProducts() {
        return userRepository
                .findAllUsersWithMoreThanOneSoldProductsOrderByLastNameThanFirstName()
                .stream()
                .map(user -> modelMapper.map(user,UserSoldDto.class))
                .collect(Collectors.toList());
    }
}
