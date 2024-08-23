package com.example.nextleveltech.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
  private String firstName;
  private String lastName;
  private int age;
  private Project project;

  public Employee() {
  }

  @Column(nullable = false)
  public String getFirstName() {
    return firstName;
  }

  @Column(nullable = false)
  public String getLastName() {
    return lastName;
  }

  @Column(nullable = false)
  public int getAge() {
    return age;
  }

  @ManyToOne
  public Project getProject() {
    return project;
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

  public void setProject(Project project) {
    this.project = project;
  }
}
