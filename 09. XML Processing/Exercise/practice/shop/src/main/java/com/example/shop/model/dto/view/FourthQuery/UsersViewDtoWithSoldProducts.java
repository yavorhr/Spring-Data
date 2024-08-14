package com.example.shop.model.dto.view.FourthQuery;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersViewDtoWithSoldProducts {

  @XmlAttribute(name = "first-name")
  private String firstName;
  @XmlAttribute(name = "last-name")
  private String lastName;
  @XmlAttribute(name = "age")
  private int age;

  @XmlElementWrapper(name = "sold-products")
  @XmlElement(name = "product")
  List<ProductNameAndPriceDto> products;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public List<ProductNameAndPriceDto> getProducts() {
    return products;
  }

  public void setProducts(List<ProductNameAndPriceDto> products) {
    this.products = products;
  }
}
