package com.example.mappingobjectslab.entity.dto;

import com.google.gson.annotations.Expose;

public class ResponseCreateManagerDto extends BasicDto {

  @Expose
  private long id;

  public ResponseCreateManagerDto() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


}
