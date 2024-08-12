package com.example.shop.model.dto.view.FirstQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductViewDtoWithNamePriceAndSellerName {

  @XmlElement
  private String name;
  @XmlElement
  private BigDecimal price;
  @XmlElement
  private String seller;
}
