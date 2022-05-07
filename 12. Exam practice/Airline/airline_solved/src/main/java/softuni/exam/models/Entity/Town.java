package softuni.exam.models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    private String name;
    private int population;
    private String guide;

    public Town() {
    }

    @Column(unique = true)
    public String getName()  {
        return name;
    }
    @Column(name = "population")
    public int getPopulation() {
        return population;
    }

    @Column(columnDefinition = "TEXT")
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
