package com.example.productshop_practice.model.dto.view.fourthQuery;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SellersCountAndSellersSoldProductsDataDto {
  @Expose
  private long usersCount;
  @Expose
  List<SellerDataAndProductCountAndDataDto> users;

  public SellersCountAndSellersSoldProductsDataDto() {
  }

  public long getUsersCount() {
    return usersCount;
  }

  public void setUsersCount(long usersCount) {
    this.usersCount = usersCount;
  }

  public List<SellerDataAndProductCountAndDataDto> getUsers() {
    return users;
  }

  public void setUsers(List<SellerDataAndProductCountAndDataDto> users) {
    this.users = users;
  }
}
