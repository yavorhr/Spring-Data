package com.example.shop.model.dto.view.FirstQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsViewRootDto {

  @XmlElement(name = "product")
  private List<ProductViewDtoWithNamePriceAndSellerName> products;

  public void setProducts(List<ProductViewDtoWithNamePriceAndSellerName> products) {
    this.products = products;
  }
}
