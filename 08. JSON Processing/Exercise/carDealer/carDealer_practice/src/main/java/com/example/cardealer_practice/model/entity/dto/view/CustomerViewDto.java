package com.example.cardealer_practice.model.entity.dto.view;

import com.google.gson.annotations.Expose;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class CustomerViewDto {
  @Expose
  private Long id;
  @Expose
  private String name;
  @Expose
  private String birthDate;
  @Expose
  private boolean isYoungDriver;

  public CustomerViewDto() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public boolean isYoungDriver() {
    return isYoungDriver;
  }

  public void setYoungDriver(boolean youngDriver) {
    isYoungDriver = youngDriver;
  }
}
