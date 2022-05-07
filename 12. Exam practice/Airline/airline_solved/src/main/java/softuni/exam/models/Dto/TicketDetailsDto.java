package softuni.exam.models.Dto;


import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketDetailsDto {

    @XmlElement(name = "serial-number")
    private String serialNumber;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "take-off")
    private String takeoff;

    @XmlElement(name = "from-town")
    private TownNameDto fromTown;

    @XmlElement(name = "to-town")
    private TownNameDto toTown;

    @XmlElement(name = "plane")
    private PlaneDto plane;
    @XmlElement(name = "passenger")
    private PassengerDto passenger;

    @Size(min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public TownNameDto getFromTown() {
        return fromTown;
    }

    public PlaneDto getPlane() {
        return plane;
    }

    public PassengerDto getPassenger() {
        return passenger;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    public void setFromTown(TownNameDto fromTown) {
        this.fromTown = fromTown;
    }

    public void setPlane(PlaneDto plane) {
        this.plane = plane;
    }

    public void setPassenger(PassengerDto passenger) {
        this.passenger = passenger;
    }

    public TownNameDto getToTown() {
        return toTown;
    }

    public void setToTown(TownNameDto toTown) {
        this.toTown = toTown;
    }
}
