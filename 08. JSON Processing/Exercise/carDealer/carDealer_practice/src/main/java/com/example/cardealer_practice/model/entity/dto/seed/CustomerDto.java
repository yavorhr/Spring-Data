package com.example.cardealer_practice.model.entity.dto.seed;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

public class CustomerDto {
  @Expose
  @Size(min = 2)
  private String name;
  @Expose
  private String birthDate;
  @Expose
  private boolean isYoungDriver;

  public CustomerDto() {
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
