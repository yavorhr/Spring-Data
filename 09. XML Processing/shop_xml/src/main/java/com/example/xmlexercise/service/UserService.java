package com.example.xmlexercise.service;

import com.example.xmlexercise.model.dto.Shop_SeedDtos.UserSeedDto;
import com.example.xmlexercise.model.dto.Shop_query2.UserViewRootDto;
import com.example.xmlexercise.model.dto.Shop_query4.UsersRootDto;
import com.example.xmlexercise.model.entity.User;

import java.util.List;

public interface UserService {
    long getCount();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UserViewRootDto findUsersWithMoreThanOneSoldProducts();

    UsersRootDto getAllUsersWithProducts();
}
