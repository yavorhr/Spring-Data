package com.example.shop.model.dto.view.ThirdQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesRootViewDto {

  @XmlElement(name = "category")
  List<CategoryViewDto> categories;

  public List<CategoryViewDto> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryViewDto> categories) {
    this.categories = categories;
  }
}
