package com.example.shop.model.dto.view.SecondQuery;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductsViewDto {

  @XmlAttribute(name = "first-name")
  private String firstName;
  @XmlAttribute(name = "last-name")
  private String lastName;

  @XmlElement(name = "products")
  @XmlElementWrapper(name = "sold-products")
  private List<ProductsWithBuyerViewDto> products;

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

  public List<ProductsWithBuyerViewDto> getProducts() {
    return products;
  }

  public void setProducts(List<ProductsWithBuyerViewDto> products) {
    this.products = products;
  }
}
