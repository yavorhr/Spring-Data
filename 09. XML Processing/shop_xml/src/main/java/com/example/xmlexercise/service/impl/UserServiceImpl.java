package com.example.xmlexercise.service.impl;

import com.example.xmlexercise.model.dto.Shop_SeedDtos.UserSeedDto;
import com.example.xmlexercise.model.dto.Shop_query2.UserViewRootDto;
import com.example.xmlexercise.model.dto.Shop_query2.UserWithSoldProductsViewDto;
import com.example.xmlexercise.model.dto.Shop_query4.UsersRootDto;
import com.example.xmlexercise.model.dto.Shop_query4.UserFullNameAndAge;
import com.example.xmlexercise.model.entity.User;
import com.example.xmlexercise.repository.UserRepository;
import com.example.xmlexercise.service.UserService;
import com.example.xmlexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public long getCount() {
        return this.userRepository.count();
    }

    @Override
    public void seedUsers(List<UserSeedDto> users) {
        users
                .stream()
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public User getRandomUser() {
        Long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public UserViewRootDto findUsersWithMoreThanOneSoldProducts() {
        UserViewRootDto userViewRootDto = new UserViewRootDto();

        userViewRootDto
                .setUsers(userRepository
                        .findAllUsersWithMoreThanOneSoldProduct()
                        .stream()
                        .map(user -> modelMapper.map(user, UserWithSoldProductsViewDto.class))
                        .collect(Collectors.toList())
                );

        return userViewRootDto;
    }

    @Override
    public UsersRootDto getAllUsersWithProducts() {
        UsersRootDto userRootDto = new UsersRootDto();

        List<UserFullNameAndAge> users = userRepository.findAllUsersWithAtLeastOneProductSold()
                .stream()
                .map(user -> modelMapper.map(user, UserFullNameAndAge.class))
                .collect(Collectors.toList());

        userRootDto.setUsers(users);
        userRootDto.setCount(users.size());
        return userRootDto;
    }
}
