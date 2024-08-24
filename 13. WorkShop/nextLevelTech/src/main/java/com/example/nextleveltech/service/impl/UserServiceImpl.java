package com.example.nextleveltech.service.impl;

import com.example.nextleveltech.model.dto.UserLoginDto;
import com.example.nextleveltech.model.dto.UserRegisterDto;
import com.example.nextleveltech.model.entity.User;
import com.example.nextleveltech.repositoriy.UserRepository;
import com.example.nextleveltech.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

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
    if (emailAlreadyTaken(dto) || passwordDoesNotMatch(dto) || usernameAlreadyTaken(dto)) {
      return false;
    }

    User user = this.modelMapper.map(dto, User.class);
    this.userRepository.save(user);

    return true;
  }

  // Helpers
  private boolean usernameAlreadyTaken(UserRegisterDto dto) {
    if (this.userRepository.findByUsername(dto.getUsername()).isPresent()) {
      return true;
    }
    return false;
  }


  private boolean emailAlreadyTaken(UserRegisterDto dto) {
    if (this.userRepository.findByEmail(dto.getEmail()).isPresent()) {
      return true;
    }
    return false;
  }

  private boolean passwordDoesNotMatch(UserRegisterDto dto) {
    if (!dto.getPassword().equals(dto.getConfirmPassword())) {
      return true;
    }
    return false;
  }

  @Override
  public Long validateUserLoginDetails(UserLoginDto dto) {
    Optional<User> user =
            this.userRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());

    if (user.isEmpty()) {
      return null;
    }

    return user.get().getId();
  }

}
