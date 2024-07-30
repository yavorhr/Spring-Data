package com.example.cardealer_practice.model.entity.dto.seed;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;

public class SupplierDto {
  @Expose
  @Size(min = 2)
  private String name;
  @Expose
  private boolean isImporter;

  public SupplierDto() {
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isImporter() {
    return isImporter;
  }

  public void setImporter(boolean importer) {
    isImporter = importer;
  }
}
