package softuni.exam.models.dto.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownsSeedDtos {
  @Expose
  private String townName;
  @Expose
  private int population;

  @Size(min = 2)
  @NotNull
  public String getTownName() {
    return townName;
  }

  @NotNull
  @Positive
  public int getPopulation() {
    return population;
  }

  public void setTownName(String townName) {
    this.townName = townName;
  }

  public void setPopulation(int population) {
    this.population = population;
  }
}
