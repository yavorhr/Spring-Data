package com.example.productshop_practice.service.impl;

import com.example.productshop_practice.constant.GlobalConstants;
import com.example.productshop_practice.model.dto.UserSeedDto;
import com.example.productshop_practice.model.dto.view.fourthQuery.ProductDto;
import com.example.productshop_practice.model.dto.view.fourthQuery.ProductsCountAndDataDto;
import com.example.productshop_practice.model.dto.view.secondQuery.SellerWithSoldProductsDto;
import com.example.productshop_practice.model.dto.view.fourthQuery.SellersCountAndSellersSoldProductsDataDto;
import com.example.productshop_practice.model.dto.view.fourthQuery.SellerDataAndProductCountAndDataDto;
import com.example.productshop_practice.model.entity.User;
import com.example.productshop_practice.repository.UserRepository;
import com.example.productshop_practice.service.UserService;
import com.example.productshop_practice.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final Gson gson;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;

  public UserServiceImpl(UserRepository userRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
    this.userRepository = userRepository;
    this.gson = gson;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public void seedUsers() throws IOException {
    if (this.userRepository.count() == 0) {
      String usersJson = Files.readString(Path.of(GlobalConstants.SEED_USERS_PATH));

      UserSeedDto[] userSeedDtos = this.gson.fromJson(usersJson, UserSeedDto[].class);
      Arrays.stream(userSeedDtos)
              .filter(validationUtil::isValid)
              .map(u -> this.modelMapper.map(u, User.class))
              .forEach(this.userRepository::save);
    }
  }

  @Override
  public User findRandomUser() {
    long randomId = ThreadLocalRandom.current().nextLong(1, this.userRepository.count() + 1);
    return this.userRepository
            .findById(randomId)
            .orElse(null);
  }

  @Override
  public List<SellerWithSoldProductsDto> findAllUsersWithMoreThanOneSoldProducts() {
    List<User> users = this.userRepository
            .findAllUsersWithMoreThanOneSoldProductsOrderByLastNameThanFirstName();

    return
            users.stream().map(u -> modelMapper.map(u, SellerWithSoldProductsDto.class))
                    .collect(Collectors.toList());

  }

  @Override
  public SellersCountAndSellersSoldProductsDataDto findAllUsersCountWithMoreThanOneSoldProducts() {
    List<User> users = this.userRepository
            .findAllBySoldProductsCount();

    SellersCountAndSellersSoldProductsDataDto sellersDto = new SellersCountAndSellersSoldProductsDataDto();
    sellersDto.setUsersCount(users.size());

//    {
//      "usersCount":35,
//            "users": {}

    List<SellerDataAndProductCountAndDataDto> collect = users
            .stream()
            .map(u -> {
                      SellerDataAndProductCountAndDataDto sellerDataAndProductCountAndDataDto =
                              this.modelMapper.map(u, SellerDataAndProductCountAndDataDto.class);

                      List<ProductDto> productDtos =
                              Arrays.stream(modelMapper.map(u.getSoldProducts(), ProductDto[].class)).toList();

                      sellerDataAndProductCountAndDataDto.setSoldProducts(productDtos);
                      return sellerDataAndProductCountAndDataDto;
                    }
            ).collect(Collectors.toList());

    sellersDto.setUsers(collect);

    return sellersDto;
  }
}

