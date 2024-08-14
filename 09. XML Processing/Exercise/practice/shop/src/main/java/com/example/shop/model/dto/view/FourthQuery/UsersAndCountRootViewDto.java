package com.example.shop.model.dto.view.FourthQuery;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersAndCountRootViewDto {
  @XmlAttribute(name = "count")
  private int count;

  @XmlElement(name = "user")
  private List<UsersViewDtoWithSoldProducts> users;

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public List<UsersViewDtoWithSoldProducts> getUsers() {
    return users;
  }

  public void setUsers(List<UsersViewDtoWithSoldProducts> users) {
    this.users = users;
  }
}
