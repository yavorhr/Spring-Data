package com.example.mappingobjectslab.entity.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

  private Long id;

  private String firstName;

  private String lastName;

  private BigDecimal salary;

  private Date date;

  private String address;

  private boolean isOnHoliday;

  private Employee manager;

  private Set<Employee> subordinates;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public boolean isOnHoliday() {
    return isOnHoliday;
  }

  public void setOnHoliday(boolean onHoliday) {
    isOnHoliday = onHoliday;
  }

  @ManyToOne
  public Employee getManager() {
    return manager;
  }

  public void setManager(Employee manager) {
    this.manager = manager;
  }

  @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
  public Set<Employee> getSubordinates() {
    return subordinates;
  }

  public void setSubordinates(Set<Employee> subordinates) {
    this.subordinates = subordinates;
  }
}
