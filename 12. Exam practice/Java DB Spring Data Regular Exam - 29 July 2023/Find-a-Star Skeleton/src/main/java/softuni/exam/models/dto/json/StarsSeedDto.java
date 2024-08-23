package softuni.exam.models.dto.json;

import softuni.exam.models.entity.StarTypeEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class StarsSeedDto {
  private String description;
  private Double lightYears;
  private String name;
  private StarTypeEnum starType;
  private Long constellationId;

  @NotNull
  @Size(min = 6)
  public String getDescription() {
    return description;
  }

  @NotNull
  @Positive
  public Double getLightYears() {
    return lightYears;
  }

  @NotNull
  @Size(min = 2,max = 30)
  public String getName() {
    return name;
  }

  @NotNull
  public StarTypeEnum getStarType() {
    return starType;
  }

  @NotNull
  public Long getConstellationId() {
    return constellationId;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setLightYears(Double lightYears) {
    this.lightYears = lightYears;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStarType(StarTypeEnum starType) {
    this.starType = starType;
  }

  public void setConstellationId(Long constellationId) {
    this.constellationId = constellationId;
  }
}
