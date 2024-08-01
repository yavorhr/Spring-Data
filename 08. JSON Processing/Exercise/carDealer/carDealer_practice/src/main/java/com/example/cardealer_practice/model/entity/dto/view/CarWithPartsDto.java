package com.example.cardealer_practice.model.entity.dto.view;

import com.example.cardealer_practice.model.entity.dto.view.fifthQuery.CarViewDto;
import com.google.gson.annotations.Expose;

import java.util.List;

public class CarWithPartsDto extends CarViewDto {
  @Expose
  private List<PartViewDto> parts;

  public CarWithPartsDto() {
  }

  public List<PartViewDto> getParts() {
    return parts;
  }

  public void setParts(List<PartViewDto> parts) {
    this.parts = parts;
  }
}
