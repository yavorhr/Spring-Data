package softuni.exam.models.Dto;

import javax.persistence.Column;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlanesDetailsDto {

    @XmlElement(name = "register-number")
    private String registerNumber;
    @XmlElement(name = "capacity")
    private int capacity;
    @XmlElement(name = "airline")
    private String airline;

    @Size(min = 5)
    public String getRegisterNumber() {
        return registerNumber;
    }
    @Positive
    public int getCapacity() {
        return capacity;
    }
    @Size(min = 2)
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
