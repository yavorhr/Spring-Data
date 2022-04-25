package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "prescribed_medicaments")
public class Medicament extends BaseEntity{
    private String name;
    @ManyToOne
    private Patient patient;

    public Medicament() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
