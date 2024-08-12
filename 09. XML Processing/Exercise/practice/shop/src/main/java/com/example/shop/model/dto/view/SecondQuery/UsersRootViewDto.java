package com.example.shop.model.dto.view.SecondQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersRootViewDto {

  @XmlElement(name = "user")
  List<UserWithSoldProductsViewDto> user;

  public void setUser(List<UserWithSoldProductsViewDto> user) {
    this.user = user;
  }
}
