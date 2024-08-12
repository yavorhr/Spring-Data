package com.example.shop.service.impl;

import com.example.shop.constant.ProjectConstants;
import com.example.shop.model.dto.seed.UserSeedRootDto;
import com.example.shop.model.entity.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.UserService;
import com.example.shop.util.ValidationUtil;
import com.example.shop.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Service
public class UserServiceImpl implements UserService {
  private final ModelMapper modelMapper;
  private final UserRepository userRepository;
  private final XmlParser xmlParser;
  private final ValidationUtil validationUtil;

  public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, XmlParser xmlParser, ValidationUtil validationUtil) {
    this.modelMapper = modelMapper;
    this.userRepository = userRepository;
    this.xmlParser = xmlParser;
    this.validationUtil = validationUtil;
  }

  @Override
  public void seedUsers() throws JAXBException, FileNotFoundException {
    if (this.userRepository.count() > 0) {
      return;
    }

    UserSeedRootDto userSeedRootDto =
            this.xmlParser.fromFile(ProjectConstants.SEED_USERS_PATH, UserSeedRootDto.class);

    System.out.println();

    userSeedRootDto.getUsers()
            .stream()
            .filter(this.validationUtil::isValid)
            .map(u -> this.modelMapper.map(u, User.class))
            .forEach(this.userRepository::save);
  }
}
