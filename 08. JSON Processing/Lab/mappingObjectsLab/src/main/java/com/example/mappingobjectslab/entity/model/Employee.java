package com.example.mappingobjectslab.entity.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

  private long id;
  private String firstName;
  private String lastName;
  private BigDecimal salary;
  private LocalDate birthday;
  private String address;
  private boolean isOnHoliday;

  private Employee manager;
  private List<Employee> subordinates;

  public Employee() {
    this.subordinates = new ArrayList<>();
  }

  public boolean isOnHoliday() {
    return isOnHoliday;
  }

  @ManyToOne
  public Employee getManager() {
    return manager;
  }

  @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
  public List<Employee> getSubordinates() {
    return subordinates;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long getId() {
    return this.id;
  }

  @Column(name = "first_name", nullable = false)
  public String getFirstName() {
    return this.firstName;
  }

  @Column(name = "last_name", nullable = false)
  public String getLastName() {
    return this.lastName;
  }

  @Column(name = "salary")
  public BigDecimal getSalary() {
    return this.salary;
  }

  @Column(name = "birthday")
  public LocalDate getBirthday() {
    return this.birthday;
  }

  @Column(name = "address")
  public String getAddress() {
    return this.address;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setOnHoliday(boolean onHoliday) {
    isOnHoliday = onHoliday;
  }

  public void setManager(Employee manager) {
    this.manager = manager;
  }

  public void setSubordinates(List<Employee> subordinates) {
    this.subordinates = subordinates;
  }
}
