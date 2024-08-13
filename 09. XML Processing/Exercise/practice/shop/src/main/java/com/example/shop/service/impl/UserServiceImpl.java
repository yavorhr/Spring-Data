package com.example.shop.service.impl;

import com.example.shop.constant.ProjectConstants;
import com.example.shop.model.dto.seed.UserSeedRootDto;
import com.example.shop.model.dto.view.SecondQuery.UserWithSoldProductsViewDto;
import com.example.shop.model.dto.view.SecondQuery.UsersRootViewDto;
import com.example.shop.model.entity.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.UserService;
import com.example.shop.util.ValidationUtil;
import com.example.shop.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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
            this.xmlParser.fromFile(ProjectConstants.SEED_USERS, UserSeedRootDto.class);

    System.out.println();

    userSeedRootDto.getUsers()
            .stream()
            .filter(this.validationUtil::isValid)
            .map(u -> this.modelMapper.map(u, User.class))
            .forEach(this.userRepository::save);
  }

  @Override
  public User getRandomUser() {
    Long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
    return userRepository.findById(randomId).orElse(null);
  }

  @Override
  public UsersRootViewDto findUsersWithMoreThanOneSoldProducts() {
    List<User> userEntities =
            this.userRepository.findAllUsersWithMoreThanOneSoldProduct();

    var rootDto = new UsersRootViewDto();

    List<UserWithSoldProductsViewDto> innerDtos = userEntities
            .stream()
            .map(e -> this.modelMapper.map(e, UserWithSoldProductsViewDto.class))
            .collect(Collectors.toList());

    rootDto.setUsers(innerDtos);
    return rootDto;
  }
}
