package com.example.nextleveltech.service.impl;

import com.example.nextleveltech.model.dto.UserRegisterDto;
import com.example.nextleveltech.model.entity.User;
import com.example.nextleveltech.repositoriy.UserRepository;
import com.example.nextleveltech.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {

    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public boolean registerUser(UserRegisterDto dto) {
    if (this.userRepository.findByUsername(dto.getUsername()).isPresent()) {
      return false;
    }

    if (this.userRepository.findByEmail(dto.getEmail()).isPresent()) {
      return false;
    }

    if (!dto.getPassword().equals(dto.getConfirmPassword())) {
      return false;
    }

    User user = this.modelMapper.map(dto, User.class);
    this.userRepository.save(user);

    return true;
  }
}
