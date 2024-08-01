package com.example.cardealer_practice.model.entity.dto.view;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SupplierVewDto {
  @Expose
  private long id;
  @Expose
  private String name;
  @Expose
  private int partsCount;

  public SupplierVewDto() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getPartsCount() {
    return partsCount;
  }

  public void setPartsCount(int partsCount) {
    this.partsCount = partsCount;
  }
}
