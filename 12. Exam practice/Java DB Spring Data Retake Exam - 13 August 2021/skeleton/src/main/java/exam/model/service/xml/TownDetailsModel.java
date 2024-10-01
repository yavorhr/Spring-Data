package exam.model.service.xml;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownDetailsModel {
  private String name;
  private Integer population;
  private String travelGuide;

  public TownDetailsModel() {
  }

  @NotNull
  @Size(min = 2)
  public String getName() {
    return name;
  }

  @NotNull
  @Positive
  public Integer getPopulation() {
    return population;
  }

  @NotNull
  @Size(min = 10)
  public String getTravelGuide() {
    return travelGuide;
  }

  public TownDetailsModel setName(String name) {
    this.name = name;
    return this;
  }

  public TownDetailsModel setPopulation(Integer population) {
    this.population = population;
    return this;
  }

  public TownDetailsModel setTravelGuide(String travelGuide) {
    this.travelGuide = travelGuide;
    return this;
  }
}
