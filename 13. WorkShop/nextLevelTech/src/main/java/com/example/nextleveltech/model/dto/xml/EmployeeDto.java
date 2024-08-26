package com.example.nextleveltech.model.dto.xml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeDto {
  @XmlElement(name = "first-name")
  private String firstName;
  @XmlElement(name = "last-name")
  private String lastName;
  @XmlElement
  private int age;
  @XmlElement
  private ProjectDto projectDto;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
