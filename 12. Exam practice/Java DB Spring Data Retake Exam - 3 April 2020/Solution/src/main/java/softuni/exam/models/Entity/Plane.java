package softuni.exam.models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
public class Plane extends BaseEntity {

    private String registerNumber;
    private int capacity;
    private String airline;

    public Plane() {
    }

    @Column(name = "register_number",unique = true)
    public String getRegisterNumber() {
        return registerNumber;
    }
    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }
    @Column(name = "airline")
    public String getAirline() {
        return airline;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
