package com.example.shop.model.dto.seed;

import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedDto {

  @XmlAttribute(name = "first-name")
  private String firstName;
  @XmlAttribute(name = "last-name")
  private String lastName;
  @XmlAttribute(name = "age")
  private int age;

  public String getFirstName() {
    return firstName;
  }

  @Size(min = 3)
  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }
}
