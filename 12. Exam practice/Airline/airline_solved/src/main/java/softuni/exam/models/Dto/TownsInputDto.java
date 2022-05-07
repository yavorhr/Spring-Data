package softuni.exam.models.Dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownsInputDto {

    @Expose
    private String name;
    @Expose
    private int population;
    @Expose
    private String guide;

    @Size(min = 2)
    public String getName() {
        return name;
    }

    @Positive
    public int getPopulation() {
        return population;
    }

    public String getGuide() {
        return guide;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}
